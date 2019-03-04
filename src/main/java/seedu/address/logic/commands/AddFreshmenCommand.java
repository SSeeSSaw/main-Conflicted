package seedu.address.logic.commands;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.freshmen.Freshmen;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

/**
 * Adds a person to the address book.
 */
public class AddFreshmenCommand extends Command {

    public static final String COMMAND_WORD = "add_f";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a freshmen to the address book. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_TAG + "friends "
            + PREFIX_TAG + "owesMoney";

    public static final String MESSAGE_SUCCESS = "New freshman added: %1$s";
    public static final String MESSAGE_DUPLICATE_FRESHMEN = "This freshmen already exists in the address book";

    private final Freshmen toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddFreshmenCommand(Freshmen freshmen) {
        requireNonNull(freshmen);
        toAdd = freshmen;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        if (model.hasFreshmen(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_FRESHMEN);
        }

        model.addFreshmen(toAdd);
        model.commitAddressBook();
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddFreshmenCommand // instanceof handles nulls
                && toAdd.equals(((AddFreshmenCommand) other).toAdd));
    }
}
