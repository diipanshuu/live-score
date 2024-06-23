package dev.dipanshu.livescore.controller;

import dev.dipanshu.livescore.service.CricInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CricInfoController {

    private CricInfoService cricInfoService;

    public CricInfoController(CricInfoService cricInfoService) {
        this.cricInfoService = cricInfoService;
    }

    @GetMapping("/score")
    public String getScore(){
        return cricInfoService.getLatestScore();
    }
}
