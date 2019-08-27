package org.sybrenbolandit.exclamation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sybrenbolandit.exclamation.service.ExclamationService;

@RestController
public class ExclamationController {

    private ExclamationService exclamationService;

    @Autowired
    public ExclamationController(ExclamationService exclamationService) {
        this.exclamationService = exclamationService;
    }

    @GetMapping("/screem")
    @ResponseBody
    public String screem(@RequestParam(defaultValue = "Hee") String message) {
        return message + exclamationService.fetchExclamations();
    }
}
