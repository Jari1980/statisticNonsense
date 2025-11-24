package com.statistics.statisticNonsense.controller;

import com.statistics.statisticNonsense.model.ButtonLog;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatisticController {

    @PostMapping("/button/A")
    public ButtonLog buttona(@RequestParam String value){
        return null;
    }

    @PostMapping("/button/B")
    public ButtonLog buttonb(@RequestParam String value){
        return null;
    }

    @GetMapping("clicks")
    public List<ButtonLog> getLogs() {
        return null;
    }
}
