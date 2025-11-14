# 时间: 2025/11/7 09:26
import uuid

from fastapi import APIRouter, UploadFile, File, Form, HTTPException, BackgroundTasks
from pathlib import Path

from app.features.excelio.schemas import ImportStatus
from app.features.excelio.services import save_upload, process_import_task

router = APIRouter(prefix="/api/excel")

ALLOWED_SUFFIXES = [".xlsx", ".xls", ".csv"]
BASE_TMP = Path("./.temp/imports")
BASE_TMP.mkdir(parents=True, exist_ok=True)

PROGRESS: dict[str, ImportStatus] = {}


@router.post("/import")
async def import_excel(
        background_tasks: BackgroundTasks,
        file: UploadFile = File(...),
        entity: str = Form(...),
        mode: str = Form("dry-run"),
        batch_size: int = Form(500),
):
    suffix = validate_file_suffix(file.filename) #校验文件名后缀

    task_id = new_task_id()                     #生成随机task_id
    task_dir = make_task_dir(task_id)           #生成文件夹
    src = task_dir.joinpath(f"original{suffix}")  #生成临时文件path

    await save_upload(src, file)
    await file.close()

    PROGRESS[task_id] = ImportStatus(taskId=task_id, status="queued", entity=entity, mode=mode)
    background_tasks.add_task(process_import_task,task_id, src, entity, mode, batch_size, PROGRESS)

    return {"taskId": task_id, "status": "queued", "mode": mode, "entity": entity}


def make_task_dir(task_id: str) -> Path:
    task_dir = BASE_TMP.joinpath(task_id)
    task_dir.mkdir(parents=True, exist_ok=True)
    return task_dir


def new_task_id() -> str:
    task_id = f"imp_{uuid.uuid4().hex[:12]}"
    return task_id


def validate_file_suffix(filename: str):
    if not filename:
        raise HTTPException(status_code=400, detail="No file part")
    if not any(filename.endswith(ext) for ext in ALLOWED_SUFFIXES):
        raise HTTPException(status_code=400, detail="No xlsx file selected")
    return Path(filename).suffix.lower()





