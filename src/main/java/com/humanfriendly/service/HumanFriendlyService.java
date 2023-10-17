package com.humanfriendly.service;

import com.humanfriendly.dto.Hour;
import com.humanfriendly.dto.Minute;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

import static com.humanfriendly.constant.Constants.*;

@Service
@Slf4j
public class HumanFriendlyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HumanFriendlyService.class);

    public String getHumanFriendlyTime(LocalTime time) {
        LOGGER.info("Timer service started: {}", time);

        int hour = time.getHour();
        int minute = time.getMinute();

        if (minute == 0) {
            return Hour.fromInt(hour) + O_CLOCK;
        } else if (minute <= 29) {
            return Minute.fromInt(minute) + PAST + Hour.fromInt(hour);
        } else if (minute == 30) {
            return HALF_PAST + Hour.fromInt(hour);
        } else {
            int remainingMinutes = 60 - minute;
            return Minute.fromInt(remainingMinutes) + TO + Hour.fromInt((hour + 1) % 24);
        }
    }
}
