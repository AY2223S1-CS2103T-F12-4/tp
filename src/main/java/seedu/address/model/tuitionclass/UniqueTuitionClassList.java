package seedu.address.model.tuitionclass;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;
import seedu.address.model.tuitionclass.exceptions.DuplicateTuitionClassException;
import seedu.address.model.tuitionclass.exceptions.TuitionClassNotFoundException;

/**
 * A list of tuition classes that enforces uniqueness between its elements and does not allow nulls.
 * A tuition class is considered unique by comparing using {@code TuitionClass#isSameTuitionClass(TuitionClass)}. As such, adding and updating of
 * tuition classes uses TuitionClass#isSameTuitionClass(TuitionClass) for equality so as to ensure that the tuition class being added or updated is
 * unique in terms of identity in the UniqueTuitionClassList. However, the removal of a tuition class uses TuitionClass#equals(Object) so
 * as to ensure that the tuition class with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see TuitionClass#isSameTuitionClass(TuitionClass)
 */
public class UniqueTuitionClassList implements Iterable<TuitionClass> {

    private final ObservableList<TuitionClass> internalList = FXCollections.observableArrayList();
    private final ObservableList<TuitionClass> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent tuition class as the given argument.
     */
    public boolean contains(TuitionClass toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameTuitionClass);
    }

    /**
     * Adds a tuition class to the list.
     * The tuition class must not already exist in the list.
     */
    public void add(TuitionClass toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateTuitionClassException();
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the tuition class {@code target} in the list with {@code editedTuitionClass}.
     * {@code target} must exist in the list.
     * The tuition class identity of {@code editedTuitionClass} must not be the same as another existing tuition
     * class in the list.
     */
    public void setTuitionClass(TuitionClass target, TuitionClass editedTuitionClass) {
        requireAllNonNull(target, editedTuitionClass);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new PersonNotFoundException();
        }

        if (!target.isSameTuitionClass(editedTuitionClass) && contains(editedTuitionClass)) {
            throw new DuplicatePersonException();
        }

        internalList.set(index, editedTuitionClass);
    }

    /**
     * Removes the equivalent tuition class from the list.
     * The tuition class must exist in the list.
     */
    public void remove(TuitionClass toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new TuitionClassNotFoundException();
        }
    }

    public void setTuitionClasses(UniqueTuitionClassList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code tuition classes}.
     * {@code tuition classes} must not contain duplicate tuition classes.
     */
    public void setTuitionClasses(List<TuitionClass> tuitionClasses) {
        requireAllNonNull(tuitionClasses);
        if (!tuitionClassesAreUnique(tuitionClasses)) {
            throw new DuplicateTuitionClassException();
        }

        internalList.setAll(tuitionClasses);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<TuitionClass> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<TuitionClass> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueTuitionClassList // instanceof handles nulls
                && internalList.equals(((UniqueTuitionClassList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    /**
     * Returns true if {@code tuition classes} contains only unique tuition classes.
     */
    private boolean tuitionClassesAreUnique(List<TuitionClass> tuitionClasses) {
        for (int i = 0; i < tuitionClasses.size() - 1; i++) {
            for (int j = i + 1; j < tuitionClasses.size(); j++) {
                if (tuitionClasses.get(i).isSameTuitionClass(tuitionClasses.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
