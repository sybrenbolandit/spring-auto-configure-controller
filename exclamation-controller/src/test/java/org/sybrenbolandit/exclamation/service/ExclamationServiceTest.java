package org.sybrenbolandit.exclamation.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExclamationServiceTest {

    @Test
    public void fetchExclamationShouldReturnNumberOfExclamationMarks() {
        ExclamationService exclamationService = new ExclamationService(2);

        assertEquals("!!", exclamationService.fetchExclamations());
    }

    @Test
    public void fetchExclamationShouldReturnNoExclamationMarks() {
        ExclamationService exclamationService = new ExclamationService(0);

        assertEquals("", exclamationService.fetchExclamations());
    }
}
