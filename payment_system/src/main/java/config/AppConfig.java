package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
    "processor",
    "service",
    "service_impl",
    "logger"
})
public class AppConfig {
}