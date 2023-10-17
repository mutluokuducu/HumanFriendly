package com.humanfriendly;

import com.humanfriendly.service.HumanFriendlyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;

@SpringBootApplication
@Slf4j
public class HumanFriendlyApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(HumanFriendlyApp.class);

    public static void main(String[] args) {
        if (args.length > 0) {
            HumanFriendlyService service = new HumanFriendlyService();
            String result = service.getHumanFriendlyTime(LocalTime.parse(args[0]));
            LOGGER.info("Command line test *******");
            LOGGER.info("{}: {}", args[0], result);
        } else {
            SpringApplication.run(HumanFriendlyApp.class, args);
        }
    }
}
