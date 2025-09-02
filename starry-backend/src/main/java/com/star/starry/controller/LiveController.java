package com.star.starry.controller;

import com.star.starry.model.dto.LiveCard;
import com.star.starry.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LiveController {

    @Autowired
    public LiveService liveService;

    @GetMapping("/lives")
    public ResponseEntity<List<LiveCard>> getHotLives(int i){
        return ResponseEntity.ok(liveService.getHotLives(3));
    }
}
