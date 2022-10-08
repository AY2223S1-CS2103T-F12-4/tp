package seedu.address.model.person.tutor;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Represents a Tutor in the address book.
 */
public class Tutor extends Person {

    private final Qualification qualification;
    private final Institution institution;

    /**
     * Every field must be present and not null.
     */
    public Tutor(Name name, Phone phone, Email email, Address address, Set<Tag> tags,
                 Qualification qualification, Institution institution) {
        super(name, phone, email, address, tags);
        requireAllNonNull(qualification, institution);
        this.qualification = qualification;
        this.institution = institution;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public Institution getInstitution() {
        return institution;
    }

    /**
     * Returns true if both tutors have the same identity and data fields.
     * This defines a stronger notion of equality between two tutors.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tutor)) {
            return false;
        }

        Tutor otherTutor = (Tutor) other;

        if (!(this.equals(otherTutor))) {
            return false;
        }

        return otherTutor.getQualification().equals(getQualification())
                && otherTutor.getInstitution().equals(getInstitution());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(this.getName(), this.getPhone(), this.getEmail(), this.getAddress(), this.getTags(),
                qualification, institution);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append(this)
                .append("; Highest Qualification: ")
                .append(getQualification())
                .append("; Institution: ")
                .append(getInstitution());

        return builder.toString();
    }
}
