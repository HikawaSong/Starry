# 时间: 2025/11/7 13:38
from typing import Literal, Optional, List, Dict, Any
from datetime import date

import pandas as pd
from pydantic import BaseModel,model_validator
from pydantic.v1 import ConfigDict


class ImportStatus(BaseModel):
    taskId: str
    status: Literal["queued", "running", "done", "failed"]
    entity: str
    mode: Literal["dry-run", "commit"]
    total: int = 0
    processed: int = 0
    failed: int = 0
    percent: float = 0.0
    error_report_url: Optional[str] = None
    message: Optional[str] = None


class LiveDTO(BaseModel):
    title: str
    place: str
    venue: str
    date: date
    img_key: str

    model_config = ConfigDict(extra='ignore')

ENTITY_TO_DTO = {
    "lives": LiveDTO
}

def to_dtos(entity: str, df:pd.DataFrame) -> List[Dict[str, Any]]:
    dto_cls = ENTITY_TO_DTO.get(entity)
    if not dto_cls:
        raise ValueError(f"Entity {entity} not supported")
    records = df.to_dict(orient="records")
    out:List[Dict[str, Any]] = []
    for record in records:
        model = dto_cls.model_validate(record)
        out.append(model.model_dump())
    return out
