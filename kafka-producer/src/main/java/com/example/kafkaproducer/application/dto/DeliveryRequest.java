package com.example.kafkaproducer.application.dto;

import lombok.Getter;

@Getter
public class DeliveryRequest {

    private String id;
    private String serviceDeliveryType;
    private String serviceDeliveryId;

    private DeliveryRequest() {
    }
}
