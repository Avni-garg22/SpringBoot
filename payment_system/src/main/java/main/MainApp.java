package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import processor.PaymentProcessor;


public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Spring context started");

        PaymentProcessor processor =
                context.getBean(PaymentProcessor.class);

        processor.makePayment(500);

        System.out.println("Requesting another UPI payment bean...");
        processor.makePayment(1000);

        context.close();
    }
}
