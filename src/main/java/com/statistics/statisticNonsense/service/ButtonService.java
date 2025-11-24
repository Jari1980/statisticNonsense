package com.statistics.statisticNonsense.service;

import com.statistics.statisticNonsense.model.ButtonLog;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ButtonService {

    private final List<ButtonLog> buttonClicks = new ArrayList<>();
    private final String csvFile = "button_clicks.csv";

    public ButtonLog registerClick(String button, String value){
        LocalDateTime now = LocalDateTime.now();
        ButtonLog click = new ButtonLog(button, value, now);

        buttonClicks.add(click);
        writeToCsv(click);

        return click;
    }

    public List<ButtonLog> getLogs(){
        List<ButtonLog> clicks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    clicks.add(new ButtonLog(
                            fields[0],
                            new String(fields[1]),
                            LocalDateTime.parse(fields[2])
                    ));
                }
            }
        } catch (IOException e) {
        }

        return clicks;
    }

    private void writeToCsv(ButtonLog click) {
        try (FileWriter writer = new FileWriter(csvFile, true)) {
            writer.append(click.getButton()).append(",")
                    .append(String.valueOf(click.getValue())).append(",")
                    .append(String.valueOf(click.getTime())).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
