package org.sybrenbolandit.exclamation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sybrenbolandit.exclamation.controller.ExclamationController;
import org.sybrenbolandit.exclamation.service.ExclamationService;

@Configuration
public class ExclamationControllerConfig {

    @Value("${exclamation.controller.number.signs:1}")
    private int numberOfSigns;

    @Bean
    @ConditionalOnMissingBean
    public ExclamationService exclamationService() {
        return new ExclamationService(numberOfSigns);
    }

    @Bean
    @ConditionalOnMissingBean
    public ExclamationController exclamationController() {
        return new ExclamationController(exclamationService());
    }

}
