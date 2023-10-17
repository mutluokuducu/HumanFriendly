package com.humanfriendly.controller;

import com.humanfriendly.service.HumanFriendlyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HumanFriendlyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HumanFriendlyService humanFriendlyService;

    @BeforeEach
    public void setup() {
        when(humanFriendlyService.getHumanFriendlyTime(LocalTime.parse("13:00"))).thenReturn("One o'clock");
    }

    @Test
    void testGetHumanFriendlyTimeEndpointValidTime() throws Exception {
        mockMvc.perform(get("/api/v1/talking-clock")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("time", "13:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value")
                        .value("One o'clock"));
    }

    @Test
    void testGetHumanFriendlyTimeEndpointInvalidTime() throws Exception {
        mockMvc.perform(get("/api/v1/talking-clock")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("time", "00"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description")
                        .value("Text '00' could not be parsed at index 2"));
    }
}
