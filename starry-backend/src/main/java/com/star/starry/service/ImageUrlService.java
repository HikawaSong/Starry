package com.star.starry.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImageUrlService {
    @Value("${img.base}")
    String base;

    public String url(String key) { return base + key; }
}
