# 时间: 2025/11/14 11:04
from dataclasses import dataclass

@dataclass
class Event:
    title: str = ""
    dateStr: str = ""
    venue: str = ""
    img: str = ""
    category: str = ""
    remark: str = None
