package com.herbalife.unittestingspringboot.controller;

import com.herbalife.unittestingspringboot.service.RegistrationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {

    @MockBean
    private RegistrationService registrationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        String url = "/hello";
        mockMvc
                .perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    public void helloReturnsAWelcomeMessage() throws Exception {
        mockMvc
                .perform(get("/hello"))
                .andExpect(content().string("Hi!"));
    }

    @Test
    public void helloWithAName() throws Exception {
        mockMvc
                .perform(get("/hello/sam"))
                .andExpect(content().string("Hello sam"));
    }

    @Test
    public void registerForTraining() throws Exception {
        String url = "/training?email=sam.gmail.com";
        mockMvc
                .perform(post(url))
                .andExpect(status().is(201));
    }

    @Test
    public void verifyRegistrationServiceIsCalled() throws Exception {
        String email = "sam@gmail.com";
        when(registrationService.register(email)).thenReturn(true);
        String url = "/training?email=" + email;
        mockMvc
                .perform(post(url));
        verify(registrationService, times(1)).register(email);
    }

}
