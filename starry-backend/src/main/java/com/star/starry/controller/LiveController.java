package com.star.starry.controller;

import com.star.starry.model.live.Live;
import com.star.starry.model.live.LiveCard;
import com.star.starry.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lives")
public class LiveController {

    @Autowired
    public LiveService liveService;

    @GetMapping("/hot")
    public ResponseEntity<List<LiveCard>> getHotLives(@RequestParam(defaultValue = "4") int i) {
        return ResponseEntity.ok(liveService.getHotLives(i));
    }

    //todo:补充import逻辑
    @PostMapping("/import")
    public ResponseEntity<Void> importLives(@RequestBody String body) {
        System.out.println(body);
        return ResponseEntity.ok().build();
    }
}
