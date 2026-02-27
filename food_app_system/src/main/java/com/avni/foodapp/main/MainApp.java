package com.avni.foodapp.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avni.foodapp.config.FoodAppConfig;
import com.avni.foodapp.order.OrderService;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(FoodAppConfig.class);

        System.out.println("Spring context started");

        OrderService orderService =
            context.getBean(OrderService.class);

        orderService.placeOrder();

        context.close();
    }
}