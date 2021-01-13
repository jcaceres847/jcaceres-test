package enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(0, "N"),
    EAST(1, "E"),
    SOUTH(2, "S"),
    WEST(3, "W");

    private static final Map<String, Direction> BY_SHORT_NAME = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(v ->  BY_SHORT_NAME.put(v.shortName, v));
    }

    private int value;
    private String shortName;
    private Direction(int newValue, String shortNameValue) {
        value = newValue;
        shortName = shortNameValue;
    }

    public Direction getBackwardDirection() {
        return values()[(this.getValue() + 2) % 4];
    }

    public int getValue() {
        return value;
    }

    public static Direction valueOfShortName(String label) {
        return BY_SHORT_NAME.get(label);
    }
}
