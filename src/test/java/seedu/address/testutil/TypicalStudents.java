package seedu.address.testutil;

import seedu.address.model.person.student.Student;

/**
 * A utility class containing a list of {@code Student} objects to be used in tests.
 */
public class TypicalStudents {

    public static final Student STUDENT1 = new StudentBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withTags("friends")
            .withSchool("Keming Primary School")
            .withLevel("PRIMARY3")
            .withNextOfKin("Teresa Lim")
            .build();

    public static final Student STUDENT2 = new StudentBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends")
            .withSchool("Zheng Hua Secondary School")
            .withLevel("SECONDARY2")
            .withNextOfKin("Aries Toh")
            .build();

    private TypicalStudents() {} // prevents instantiation
}