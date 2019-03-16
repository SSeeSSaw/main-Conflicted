package seedu.address.logic.commands;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.storage.FreshmanStorage;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

/**
 * Lists all persons in the address book to the user.
 */
public class ListFreshmenCommand extends Command {

    public static final String COMMAND_WORD = "list_f";

    public static final String MESSAGE_SUCCESS = "Listed all freshmen";


    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        FreshmanStorage.listFreshmen();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
