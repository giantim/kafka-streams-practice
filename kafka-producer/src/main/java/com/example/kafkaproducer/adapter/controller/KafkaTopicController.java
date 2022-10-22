package com.example.kafkaproducer.adapter.controller;

import com.example.kafkaproducer.application.DeliveryKafkaProducer;
import com.example.kafkaproducer.application.dto.DeliveryRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RequestMapping("/kafka")
@RestController
public class KafkaTopicController {

    private final DeliveryKafkaProducer deliveryKafkaProducer;

    public KafkaTopicController(DeliveryKafkaProducer deliveryKafkaProducer) {
        this.deliveryKafkaProducer = deliveryKafkaProducer;
    }

    @PostMapping("/send")
    public void sendTopic(@RequestBody DeliveryRequest request) throws ExecutionException, InterruptedException {
        deliveryKafkaProducer.send(request);
    }
}
