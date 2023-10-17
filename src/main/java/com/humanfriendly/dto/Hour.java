package com.humanfriendly.dto;

public enum Hour {
    TWELVE, ONE, TWO, THREE, FOUR, FIVE,
    SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN;

    public static Hour fromInt(int hour) {
        return values()[hour % 12];
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
