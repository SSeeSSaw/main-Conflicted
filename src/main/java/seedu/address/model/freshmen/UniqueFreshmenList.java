package seedu.address.model.freshmen;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.freshmen.exceptions.DuplicateFreshmenException;
import seedu.address.model.freshmen.exceptions.FreshmenNotFoundException;

/**
 * A list of persons that enforces uniqueness between its elements and does not allow nulls.
 * A person is considered unique by comparing using {@code Person#isSamePerson(Person)}. As such, adding and updating of
 * persons uses Person#isSamePerson(Person) for equality so as to ensure that the person being added or updated is
 * unique in terms of identity in the UniquePersonList. However, the removal of a person uses Person#equals(Object) so
 * as to ensure that the person with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see Freshmen#isSamePerson(Freshmen)
 */
public class UniqueFreshmenList implements Iterable<Freshmen> {

    private final ObservableList<Freshmen> internalListF = FXCollections.observableArrayList();
    private final ObservableList<Freshmen> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalListF);

    /**
     * Returns true if the list contains an equivalent person as the given argument.
     */
    public boolean contains(Freshmen toCheck) {
        requireNonNull(toCheck);
        return internalListF.stream().anyMatch(toCheck::isSamePerson);
    }

    /**
     * Adds a person to the list.
     * The person must not already exist in the list.
     */
    public void add(Freshmen toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateFreshmenException();
        }
        internalListF.add(toAdd);
    }

    /**
     * Replaces the person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the list.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the list.
     */
    public void setPerson(Freshmen target, Freshmen editedPerson) {
        requireAllNonNull(target, editedPerson);

        int index = internalListF.indexOf(target);
        if (index == -1) {
            throw new FreshmenNotFoundException();
        }

        if (!target.isSamePerson(editedPerson) && contains(editedPerson)) {
            throw new DuplicateFreshmenException();
        }

        internalListF.set(index, editedPerson);
    }

    /**
     * Removes the equivalent person from the list.
     * The person must exist in the list.
     */
    public void remove(Freshmen toRemove) {
        requireNonNull(toRemove);
        if (!internalListF.remove(toRemove)) {
            throw new FreshmenNotFoundException();
        }
    }

    public void setPersons(UniqueFreshmenList replacement) {
        requireNonNull(replacement);
        internalListF.setAll(replacement.internalListF);
    }

    /**
     * Replaces the contents of this list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setPersons(List<Freshmen> freshmen) {
        requireAllNonNull(freshmen);
        if (!freshmenAreUnique(freshmen)) {
            throw new DuplicateFreshmenException();
        }

        internalListF.setAll(freshmen);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Freshmen> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Freshmen> iterator() {
        return internalListF.iterator();
    } //search what iterator is doing

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueFreshmenList // instanceof handles nulls
                        && internalListF.equals(((UniqueFreshmenList) other).internalListF));
    }

    @Override
    public int hashCode() {
        return internalListF.hashCode();
    }

    /**
     * Returns true if {@code persons} contains only unique persons.
     */
    private boolean freshmenAreUnique(List<Freshmen> freshmen) {
        for (int i = 0; i < freshmen.size() - 1; i++) {
            for (int j = i + 1; j < freshmen.size(); j++) {
                if (freshmen.get(i).isSamePerson(freshmen.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
