package org.sybrenbolandit.exclamation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sybrenbolandit.exclamation.service.ExclamationService;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public ExclamationService exclamationService() {
        return new ExclamationService(2);
    }
}
