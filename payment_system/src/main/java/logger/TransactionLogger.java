package logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class TransactionLogger {

    public TransactionLogger() {
        System.out.println("TransactionLogger constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Logger initialized");
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Logger destroyed");
    }
}
