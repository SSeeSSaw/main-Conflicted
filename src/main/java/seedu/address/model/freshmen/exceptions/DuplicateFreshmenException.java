package seedu.address.model.freshmen.exceptions;

/**
 * Signals that the operation will result in duplicate Persons (Persons are considered duplicates if they have the same
 * identity).
 */
public class DuplicateFreshmenException extends RuntimeException {
    public DuplicateFreshmenException() {
        super("Operation would result in duplicate persons");
    }
}
