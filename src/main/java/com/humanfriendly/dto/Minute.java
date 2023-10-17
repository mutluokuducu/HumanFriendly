package com.humanfriendly.dto;

public enum Minute {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
    ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN,
    EIGHTEEN, NINETEEN, TWENTY, TWENTY_ONE, TWENTY_TWO, TWENTY_THREE,
    TWENTY_FOUR, TWENTY_FIVE, TWENTY_SIX, TWENTY_SEVEN, TWENTY_EIGHT,
    TWENTY_NINE, THIRTY, THIRTY_ONE, THIRTY_TWO, THIRTY_THREE, THIRTY_FOUR,
    THIRTY_FIVE, THIRTY_SIX, THIRTY_SEVEN, THIRTY_EIGHT, THIRTY_NINE,
    FORTY, FORTY_ONE, FORTY_TWO, FORTY_THREE, FORTY_FOUR, FORTY_FIVE,
    FORTY_SIX, FORTY_SEVEN, FORTY_EIGHT, FORTY_NINE, FIFTY, FIFTY_ONE,
    FIFTY_TWO, FIFTY_THREE, FIFTY_FOUR, FIFTY_FIVE, FIFTY_SIX, FIFTY_SEVEN,
    FIFTY_EIGHT, FIFTY_NINE;

    public static Minute fromInt(int minute) {
        return values()[minute];
    }

    @Override
    public String toString() {
        return name().equals("ZERO") ? "" : name().charAt(0) +
                name().substring(1)
                        .toLowerCase()
                        .replace("_", " ");
    }
}
