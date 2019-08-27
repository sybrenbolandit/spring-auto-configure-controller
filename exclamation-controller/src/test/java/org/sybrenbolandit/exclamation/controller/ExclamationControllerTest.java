package org.sybrenbolandit.exclamation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.sybrenbolandit.exclamation.TestApplication;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {ExclamationController.class})
@ContextConfiguration(classes = {TestApplication.class})
public class ExclamationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void screemShouldReturnDefaultMessageWithExclamations() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/screem")
                        .header(CONTENT_TYPE, APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Hee!!")));
    }

    @Test
    public void screemShouldReturnSendMessageWithExclamations() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/screem?message=Yoooo")
                        .header(CONTENT_TYPE, APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Yoooo!!")));
    }
}
