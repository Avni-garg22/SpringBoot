package com.avni.foodapp.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avni.foodapp.delivery.DeliveryService;

@Component
public class RestaurantService {

    private DeliveryService deliveryService;

    @Autowired
    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void prepareOrder() {
        System.out.println("Restaurant preparing food");
        deliveryService.deliverOrder();
    }
}