# 时间: 2025/11/13 10:01
from dataclasses import asdict
from typing import List

import requests
from bs4 import BeautifulSoup
from setuptools.command.build_ext import if_dl

from app.features.scraper.schemas import Event

BASE_URL = "https://bang-dream.com/events"
JAVA_URL = "http://localhost:8080/api/lives/import"

WARNING_COUNT = 5

HEADERS = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/142.0.0.0 Safari/537.36"}

FIELD_MAP = {
    "開催日時": "dateStr",
    "場所": "venue",
    "概要": "remark"
}


def scrape_all_pages():
    all_events = []
    page = 1
    while page<=3:
        print(f"Scraping page {page}...")
        url = f"{BASE_URL}?page={page}"
        html = fetch_html(url)
        if not html:
            break

        events = scrape_html(html)
        if not events:
            break
        all_events.extend(events)
        page += 1

    return all_events

def fetch_html(url: str) -> str | None:
    response = requests.get(url, headers=HEADERS, timeout=10)
    if response.status_code == 404:
        return None
    response.raise_for_status()
    return response.text


def scrape_html(html: str) -> List[Event]:
    soup = BeautifulSoup(html, "html.parser")
    result: List[Event] = []
    event_set = soup.select('a[href^="/events/"]')

    for event in event_set:
        ev = Event()

        img_tag = event.select_one('.liveEventListImage img')
        ev.img = img_tag.get("src") if img_tag else None

        category_tag = event.select_one('.liveEventTagLabel')
        ev.category = category_tag.get_text(strip=True) if category_tag else None

        title_tag = event.select_one('.liveEventListTitle')
        ev.title = title_tag.get_text(strip=True) if title_tag else None

        columns = event.select(".itemInfoColumnTitle")
        datas = event.select(".itemInfoColumnData")

        for c, d in zip(columns, datas):
            column = c.get_text(strip=True)
            data = d.get_text(strip=True)
            if column in FIELD_MAP:
                field = FIELD_MAP[column]
                setattr(ev, field, data)

        result.append(ev)

    return result

def send_to_java(events:List[Event]):
    #todo: 发送格式改为map
    payload = [asdict(e) for e in events]

    resp=requests.post(JAVA_URL, json=payload)
    resp.raise_for_status()

    print("Sent ok", resp.status_code)