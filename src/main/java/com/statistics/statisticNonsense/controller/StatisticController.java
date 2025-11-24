package com.statistics.statisticNonsense.controller;

import com.statistics.statisticNonsense.model.ButtonLog;
import com.statistics.statisticNonsense.service.ButtonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatisticController {

    private final ButtonService buttonService;

    public StatisticController(ButtonService buttonService){
        this.buttonService = buttonService;
    }

    @PostMapping("/button/A")
    public ButtonLog buttona(@RequestParam String value){
        return buttonService.registerClick("A", value);
    }

    @PostMapping("/button/B")
    public ButtonLog buttonb(@RequestParam String value){
        return buttonService.registerClick("B", value);
    }

    @GetMapping("/clicks")
    public List<ButtonLog> getLogs() {
        return buttonService.getLogs();
    }
}
