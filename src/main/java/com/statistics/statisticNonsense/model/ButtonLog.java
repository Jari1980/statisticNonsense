package com.statistics.statisticNonsense.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ButtonLog {
    private String button;
    private String value;
    private LocalDateTime time;
}
