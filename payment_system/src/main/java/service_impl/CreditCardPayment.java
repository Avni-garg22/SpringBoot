package service_impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import service.PaymentService;


@Component
@Primary
public class CreditCardPayment implements PaymentService {

    public CreditCardPayment() {
        System.out.println("CreditCardPayment constructor called");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing CREDIT CARD payment of Rs." + amount);
    }
}
