package seedu.address.model.level;

import seedu.address.model.level.exceptions.InvalidLevelException;

/**
 * Represents the level of education.
 */
public enum Level {
    PRIMARY1("Primary 1"), PRIMARY2("Primary 2"), PRIMARY3("Primary 3"), PRIMARY4("Primary 4"), PRIMARY5("Primary 5"),
    PRIMARY6("Primary 6"), SECONDARY1("Secondary 1"), SECONDARY2("Secondary 2"), SECONDARY3("Secondary 3"),
    SECONDARY4("Secondary 4");

    public static final String MESSAGE_CONSTRAINTS =
            "Academic levels should only be either a primary or secondary level\n";
    public static final String MESSAGE_DID_YOU_MEAN_PRIMARY = "Did you mean \"primary\"? ";
    public static final String MESSAGE_DID_YOU_MEAN_SECONDARY = "Did you mean \"secondary\"? ";
    public static final String VALIDATION_REGEX = "(?i)(primary|pri|p)\\s*[1-6]|(secondary|sec|s)\\s*[1-4]";
    public final String level;

    Level(String level) {
        this.level = level;
    }

    /**
     * Creates a Level object depending on the inputLevel.
     *
     * @param inputLevel A string representing the level of education.
     * @return A Level object with the respective enum value.
     * @throws InvalidLevelException if the inputLevel does not match any of the enum values.
     */
    public static Level createLevel(String inputLevel) throws InvalidLevelException {
        for (Level level : Level.values()) {
            if (inputLevel.toUpperCase().equals(level.name())) {
                return level;
            }
        }
        throw new InvalidLevelException(); //change to return null?
    }

    //    /**
    //     * Returns true if a given string is a valid value in enum Level
    //     */
    //    public static boolean isValidLevel(String level) {
    //        for (Level l : Level.values()) {
    //            if (l.name().equals(level)) {
    //                return true;
    //            }
    //        }
    //        return false;
    //    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1, name().length() - 1).toLowerCase()
                + " " + name().charAt(name().length() - 1);
    }

    /**
     * Returns true if a given string is a valid value in enum Level
     */
    public static boolean isValidLevel(String test) {
        return test.matches(VALIDATION_REGEX);
    }
}
