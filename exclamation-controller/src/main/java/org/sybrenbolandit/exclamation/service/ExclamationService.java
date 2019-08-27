package org.sybrenbolandit.exclamation.service;

import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class ExclamationService {

    private int numberOfExclamations;

    public ExclamationService(int numberOfExclamations) {
        this.numberOfExclamations = numberOfExclamations;
    }

    public String fetchExclamations() {
        return IntStream.range(0, numberOfExclamations)
                .mapToObj(i -> "!")
                .reduce("", (a, b) -> a + b);
    }
}
