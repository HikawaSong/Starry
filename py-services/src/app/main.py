# 时间: 2025/11/6 14:58
from fastapi import FastAPI
from starlette.middleware.cors import CORSMiddleware

from app.features.excelio import excelio
from app.features.scraper import crawl

app = FastAPI(title="Starry Python Service")
app.include_router(excelio.router)
app.include_router(crawl.router)
@app.get("/health")
def health():
    return {"status": "ok"}

app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:5173"],  # 允许来自前端的请求
    allow_credentials=True,
    allow_methods=["*"],  # 也可以指定 ["POST", "OPTIONS"]
    allow_headers=["*"],
)