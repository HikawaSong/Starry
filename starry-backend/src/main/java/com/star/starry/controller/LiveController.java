package com.star.starry.controller;

import com.star.starry.model.dto.LiveCard;
import com.star.starry.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LiveController {

    @Autowired
    public LiveService liveService;

    @GetMapping("/lives/hot")
    public ResponseEntity<List<LiveCard>> getHotLives(@RequestParam(defaultValue = "4") int i){
        return ResponseEntity.ok(liveService.getHotLives(i));
    }
}
