package org.velosaurus.demo.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class RestControllerExample {

    @GetMapping("/hello")
    public String showExamplePage() {
        String time = ZonedDateTime.now(ZoneId.of("Europe/Vienna")).format(DateTimeFormatter.ISO_DATE_TIME);

        return "Hello, it's " + time + ". Alternative: " + LocalDateTime.now();
    }
}
