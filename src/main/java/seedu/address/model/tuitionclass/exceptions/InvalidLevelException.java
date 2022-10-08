package seedu.address.model.tuitionclass.exceptions;

public class InvalidLevelException extends RuntimeException {
    public InvalidLevelException() {
        super("Please give the level in the correct format: [Primary/Secondary][1-6]\n" + "e.g. Primary1");
    }
}