package com.humanfriendly.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HumanFriendlyServiceTests {

    private HumanFriendlyService humanFriendlyService;

    @BeforeEach
    public void setup() {
        humanFriendlyService = new HumanFriendlyService();
    }

    @Test
    void testHumanFriendlyTimeAtMidnight() {
        LocalTime time = LocalTime.of(0, 0);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Twelve o'clock", result);
    }

    @Test
    void testHumanFriendlyTimeAtNoon() {
        LocalTime time = LocalTime.of(12, 0);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Twelve o'clock", result);
    }

    @Test
    void testHumanFriendlyTimeAtQuarterPast() {
        LocalTime time = LocalTime.of(4, 15);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Fifteen past Four", result);
    }

    @Test
    void testHumanFriendlyTimeAtHalfPast() {
        LocalTime time = LocalTime.of(3, 30);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Half past Three", result);
    }

    @Test
    void testHumanFriendlyTimeAtQuarterTo() {
        LocalTime time = LocalTime.of(10, 45);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Fifteen to Eleven", result);
    }

    @Test
    void testHumanFriendlyTimeTwoPastSix() {
        LocalTime time = LocalTime.of(6, 2);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Two past Six", result);
    }

    @Test
    void testHumanFriendlyTimeThree() {
        LocalTime time = LocalTime.of(15, 00);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Three o'clock", result);
    }

    @Test
    void testHumanFriendlyTimeHalfPastFour() {
        LocalTime time = LocalTime.of(16, 30);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Half past Four", result);
    }

    @Test
    void testHumanFriendlyTimeTwentyFiveToFive() {
        LocalTime time = LocalTime.of(16, 35);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Twenty five to Five", result);
    }

    @Test
    void testHumanFriendlyTimeThirteenToNine() {
        LocalTime time = LocalTime.of(20, 47);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Thirteen to Nine", result);
    }

    @Test
    void testHumanFriendlyTimeThirteenPastTwelve() {
        LocalTime time = LocalTime.of(12, 13);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Thirteen past Twelve", result);
    }

    @Test
    void testHumanFriendlyTimeNinePastOne() {
        LocalTime time = LocalTime.of(13, 9);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Nine past One", result);
    }

    @Test
    void testHumanFriendlyTimeTwentyOneToSix() {
        LocalTime time = LocalTime.of(17, 39);
        String result = humanFriendlyService.getHumanFriendlyTime(time);
        assertEquals("Twenty one to Six", result);
    }
}
