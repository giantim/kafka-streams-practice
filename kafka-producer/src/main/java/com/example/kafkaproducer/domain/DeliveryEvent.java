package com.example.kafkaproducer.domain;

import lombok.Getter;

@Getter
public class DeliveryEvent {

    private String id;
    private String serviceDeliveryType;
    private String serviceDeliveryId;

    private DeliveryEvent() {
    }

    public static DeliveryEvent create(String id, String serviceDeliveryType, String serviceDeliveryId) {
        DeliveryEvent deliveryEvent = new DeliveryEvent();
        deliveryEvent.id = id;
        deliveryEvent.serviceDeliveryType = serviceDeliveryType;
        deliveryEvent.serviceDeliveryId = serviceDeliveryId;

        return deliveryEvent;
    }
}
