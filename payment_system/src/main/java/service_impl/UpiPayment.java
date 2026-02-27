package service_impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import service.PaymentService;


@Component("upiPayment")
@Scope("prototype")
public class UpiPayment implements PaymentService {

    public UpiPayment() {
        System.out.println("UpiPayment constructor called");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of Rs." + amount);
    }
}