package seedu.address.model.tuitionclass;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.level.Level;
import seedu.address.model.tag.Tag;

/**
 * Represents a TuitionClass in the address book.
 */
public class TuitionClass {

    private final Name name;
    private final Subject subject;
    private final Level level;
    private final Day day;
    private final Time time;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public TuitionClass(Name name, Subject subject, Level level, Day day, Time time, Set<Tag> tags) {
        requireAllNonNull(name, subject, day, time, tags);
        this.name = name;
        this.subject = subject;
        this.level = level;
        this.day = day;
        this.time = time;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Subject getSubject() {
        return subject;
    }

    public Level getLevel() {
        return level;
    }

    public Day getDay() {
        return day;
    }

    public Time getTime() {
        return time;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both tuition classes have the same name.
     * This defines a weaker notion of equality between two tuition classes.
     */
    public boolean isSameTuitionClass(TuitionClass otherClass) {
        if (otherClass == this) {
            return true;
        }

        return otherClass != null
                && otherClass.getName().equals(getName());
    }


    /**
     * Returns true if the class list contains an equivalent student as the given argument.
     */
    public boolean containsStudentInClass(Student toCheck) {
        requireNonNull(toCheck);
        return students.stream().anyMatch(toCheck::isSamePerson);
    }

    /**
     * Adds a student to the class list.
     */
    public void addStudentToClass(Student student) {
        students.add(student);
    }

    /**
     * Returns true if the class list contains an equivalent tutor as the given argument.
     */
    public boolean containsTutorInClass(Tutor toCheck) {
        requireNonNull(toCheck);
        return tutors.stream().anyMatch(toCheck::isSamePerson);
    }

    /**
     * Adds a tutor to the class list.
     */
    public void addTutorToClass(Tutor tutor) {
        tutors.add(tutor);
    }

    /**
     * Returns true if the tuition class has the same name as the specified name.
     */
    public boolean hasSameTuitionName(Name name) {
        return getName().equals(name);
    }

    /**
     * Returns true if both tuition classes have the same data fields.
     * This defines a stronger notion of equality between two tuition classes.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof TuitionClass)) {
            return false;
        }

        TuitionClass otherClass = (TuitionClass) other;
        return otherClass.getName().equals(getName())
                && otherClass.getSubject().equals(getSubject())
                && otherClass.getLevel().equals(getLevel())
                && otherClass.getDay().equals(getDay())
                && otherClass.getTime().equals(getTime())
                && otherClass.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, subject, level, day, time, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Subject: ")
                .append(getSubject())
                .append("; Level: ")
                .append(getLevel())
                .append("; Day: ")
                .append(getDay())
                .append("; Time: ")
                .append(getTime());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }
}
