package com.soumen.circuitbreakerpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CircuitBreakerPocApplication {

    public static void main(String[] args) {
       // BlockHound.install();
        SpringApplication.run(CircuitBreakerPocApplication.class, args);
    }


}
