package com.avni.foodapp.delivery;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class DeliveryService {

    public DeliveryService() {
        System.out.println("DeliveryService constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Delivery Service Ready");
    }

    public void deliverOrder() {
        System.out.println("Order is out for delivery");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Delivery Service Closed");
    }
}