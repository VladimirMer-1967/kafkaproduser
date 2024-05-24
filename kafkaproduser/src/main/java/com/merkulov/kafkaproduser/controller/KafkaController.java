package com.merkulov.kafkaproduser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "kafka")
public class KafkaController {

    private static final String KAFKA_TOPIC_NAME = "topic_name";
    private static final String KAFKA_DATA_KEY = "data_key";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(value = "/send")
    public String send(@RequestParam String message) {
        kafkaTemplate.send(KAFKA_TOPIC_NAME, KAFKA_DATA_KEY, message);
        return "Message has been sent to Kafka";
    }
}
