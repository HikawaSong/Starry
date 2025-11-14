# 时间: 2025/11/14 14:25
from fastapi import FastAPI, APIRouter

from app.features.scraper.services import scrape_all_pages, send_to_java

router = APIRouter(prefix="/api/crawl")

@router.get("/events")
async def crawl_events():
    events = scrape_all_pages()
    send_to_java(events)
    return {"status": "ok", "count": len(events)}