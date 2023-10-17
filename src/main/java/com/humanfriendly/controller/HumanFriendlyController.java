package com.humanfriendly.controller;

import com.humanfriendly.dto.response.TimeResponse;
import com.humanfriendly.service.HumanFriendlyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

import static com.humanfriendly.constant.Constants.TALKING_CLOCK_URL;

@Slf4j
@RestController
public class HumanFriendlyController {

    @Autowired
    private HumanFriendlyService humanFriendlyService;
    private static final Logger LOGGER = LoggerFactory.getLogger(HumanFriendlyController.class);

    @GetMapping(value = TALKING_CLOCK_URL)
    public TimeResponse getHumanFriendlyTime(@RequestParam(required = false) String time) {
        LOGGER.info("Timer controller started: {}", time);
        LocalTime parsedTime = time != null ? LocalTime.parse(time) : LocalTime.now();
        String result = humanFriendlyService.getHumanFriendlyTime(parsedTime);
        LOGGER.info("Timer controller response: {}", result);
        return TimeResponse.builder()
                .value(result)
                .build();
    }
}
