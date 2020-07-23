package com.coderlong.kafka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaAccessController {

    @RequestMapping("/send")
    public String getKafkaName() {
        return "kafka";
    }
}
