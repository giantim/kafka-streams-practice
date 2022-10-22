package com.example.kafkaproducer.application;

import com.example.kafkaproducer.application.dto.DeliveryRequest;
import com.example.kafkaproducer.domain.DeliveryEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class DeliveryKafkaProducer {

    private static final String TOPIC = "delivery";

    private final KafkaTemplate<String, DeliveryEvent> kafkaTemplate;

    public DeliveryKafkaProducer(KafkaTemplate<String, DeliveryEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(DeliveryRequest request) throws ExecutionException, InterruptedException {
        DeliveryEvent event = DeliveryEvent.create(request.getId(), request.getServiceDeliveryType(), request.getServiceDeliveryId());
        kafkaTemplate.send(TOPIC, event.getId(), event)
                .get();
    }
}
