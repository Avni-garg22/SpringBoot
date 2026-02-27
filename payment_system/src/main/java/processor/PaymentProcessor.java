package processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import logger.TransactionLogger;
import service.PaymentService;


@Component
public class PaymentProcessor {

    private PaymentService paymentService;

    @Autowired
    private TransactionLogger logger;

    public PaymentProcessor(
            @Qualifier("upiPayment") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void makePayment(double amount) {
        logger.log("Starting payment");
        paymentService.processPayment(amount);
        logger.log("Payment completed");
    }
}
