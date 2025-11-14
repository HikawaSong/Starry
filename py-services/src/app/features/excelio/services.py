# 时间: 2025/11/7 14:39
from pathlib import Path
import httpx

import pandas as pd
from fastapi import UploadFile, HTTPException

from app.features.excelio.schemas import to_dtos

JAVA_BASE_URL = "http://localhost:8080"
JAVA_IMPORT_PATHS = {
    "lives": "api/lives/import"
}

async def save_upload(src: Path, file: UploadFile):
    with src.open("wb") as out:
        while chunk := await file.read(1024 * 1024):
            out.write(chunk)
    await file.close()


async def process_import_task(task_id, src, entity, mode, batch_size, PROGRESS):
    status = PROGRESS[task_id]
    status.status = "running"
    PROGRESS[task_id] = status
    try:
        df = read_data(src)
        status.total = len(df)
        status.failed = 0  # todo
        status.processed = len(df)
        status.percent = 100.0

        if mode == "commit":
            dtos = to_dtos(entity, df)
            path = JAVA_IMPORT_PATHS.get(entity)
            if not path:
                raise HTTPException(status_code=400, detail="Entity not supported")

            path = JAVA_BASE_URL.join(path)
            async with httpx.AsyncClient(timeout=10) as client:
                for i in range(0, len(dtos), batch_size):
                    batch = dtos[i:i + batch_size]
                    payload = {
                        "task_id": task_id,
                        "batch_id": f"{task_id}_b{i // batch_size:03d}",
                        "records": batch,
                    }

                    resp = await client.post(path, json=payload)
                    resp.raise_for_status()
        status.status = "done"
    except Exception as e:
        status.status = "failed"
        status.message = str(e)
    finally:
        PROGRESS[task_id] = status


def read_data(path: Path):
    suffix = path.suffix.lower()
    if suffix in {".xlsx", ".xls"}:
        df = pd.read_excel(path)
    elif suffix in {".csv"}:
        df = pd.read_csv(path, encoding="utf-8")
    else:
        raise HTTPException(status_code=400, detail="Invalid file type")
    df = df.dropna(how="all").applymap(lambda x: x.strip() if isinstance(x, str) else x)
    return df
