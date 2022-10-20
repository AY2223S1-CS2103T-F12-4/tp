package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandResult.CommandType.ADD;
import static seedu.address.logic.commands.CommandResult.CommandType.ASSIGN;
import static seedu.address.logic.commands.CommandResult.CommandType.CLEAR;
import static seedu.address.logic.commands.CommandResult.CommandType.EDIT;
import static seedu.address.logic.commands.CommandResult.CommandType.EXIT;
import static seedu.address.logic.commands.CommandResult.CommandType.HELP;
import static seedu.address.logic.commands.CommandResult.CommandType.LIST;
import static seedu.address.logic.commands.CommandResult.CommandType.SHOW;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStudents.STUDENT1;
import static seedu.address.testutil.TypicalStudents.STUDENT2;
import static seedu.address.testutil.TypicalTuitionClasses.TUITIONCLASS1;
import static seedu.address.testutil.TypicalTuitionClasses.TUITIONCLASS2;
import static seedu.address.testutil.TypicalTutors.TUTOR1;
import static seedu.address.testutil.TypicalTutors.TUTOR2;

import org.junit.jupiter.api.Test;

public class CommandResultTest {

    @Test
    public void constructor_typeShow_throwsAssertionError() {
        // not allowed to pass in command type of show without specifying the index
        assertThrows(AssertionError.class, () -> new CommandResult("feedback", SHOW));
    }

    @Test
    public void isShowHelp_helpCommandType_assertTrue() {
        CommandResult commandResult = new CommandResult("feedback", HELP);
        assertTrue(commandResult.isShowHelp());
    }

    @Test
    public void isExit_exitCommandType_assertTrue() {
        CommandResult commandResult = new CommandResult("feedback", EXIT);
        assertTrue(commandResult.isExit());
    }

    @Test
    public void isList_listCommandType_assertTrue() {
        CommandResult commandResult = new CommandResult("feedback", LIST);
        assertTrue(commandResult.isList());
    }

    @Test
    public void isShow_indexOfShownEntity_assertTrue() {
        CommandResult commandResult = new CommandResult("feedback", SHOW, 0);
        assertTrue(commandResult.isShow());
    }

    @Test
    public void isUpdateListView_assignUnassignCommandType_assertTrue() {
        CommandResult commandResult = new CommandResult("feedback", ASSIGN, 0);
        assertTrue(commandResult.isUpdateListView());
    }

    @Test
    public void isUpdateDescription_assignUnassignEditCommandType_assertTrue() {
        CommandResult commandResult = new CommandResult("feedback", ASSIGN, 0);
        assertTrue(commandResult.isUpdateDescription());
        commandResult = new CommandResult("feedback", EDIT, 0);
        assertTrue(commandResult.isUpdateDescription());
    }

    @Test
    public void isDelete_deleteCommandType_assertTrue() {
        CommandResult commandResult = new CommandResult("feedback", STUDENT1);
        assertTrue(commandResult.isDelete());
    }

    @Test
    public void isAdd_addCommandType_assertTrue() {
        CommandResult commandResult = new CommandResult("feedback", ADD);
        assertTrue(commandResult.isAdd());
    }

    @Test
    public void isClear_clearCommandType_assertTrue() {
        CommandResult commandResult = new CommandResult("feedback", CLEAR);
        assertTrue(commandResult.isClear());
    }

    @Test
    public void isShowHelp_notHelpType_assertFalse() {
        CommandResult commandResult = new CommandResult("feedback", EXIT);
        assertFalse(commandResult.isShowHelp());
    }

    @Test
    public void isExit_notExitCommandType_assertFalse() {
        CommandResult commandResult = new CommandResult("feedback", HELP);
        assertFalse(commandResult.isExit());
    }

    @Test
    public void isList_notListCommandType_assertFalse() {
        CommandResult commandResult = new CommandResult("feedback", EXIT);
        assertFalse(commandResult.isList());
    }

    @Test
    public void isShow_notShowCommandType_assertFalse() {
        CommandResult commandResult = new CommandResult("feedback", EXIT);
        assertFalse(commandResult.isShow());
    }

    @Test
    public void isUpdateListView_notAssignUnassignCommandType_assertFalse() {
        CommandResult commandResult = new CommandResult("feedback", EXIT);
        assertFalse(commandResult.isUpdateListView());
    }

    @Test
    public void isUpdateDescription_notAssignUnassignEditCommandType_assertFalse() {
        CommandResult commandResult = new CommandResult("feedback", EXIT);
        assertFalse(commandResult.isUpdateDescription());
    }

    @Test
    public void isDelete_notDeleteCommandType_assertFalse() {
        CommandResult commandResult = new CommandResult("feedback", LIST);
        assertFalse(commandResult.isDelete());
    }

    @Test
    public void isAdd_notAddCommandType_assertFalse() {
        CommandResult commandResult = new CommandResult("feedback", LIST);
        assertFalse(commandResult.isAdd());
    }

    @Test
    public void isClear_notClearCommandType_assertFalse() {
        CommandResult commandResult = new CommandResult("feedback", LIST);
        assertFalse(commandResult.isClear());
    }
    @Test
    public void getFeedbackToUser_feedback_EqualToFeedback() {
        String feedback = "feedback";
        CommandResult commandResult = new CommandResult(feedback);
        assertEquals(feedback, commandResult.getFeedbackToUser());
    }

    @Test
    public void getIndex_notShowEditAssignCommandType_throwsAssertionError() {
        CommandResult commandResult = new CommandResult("feedback", EXIT);
        assertThrows(AssertionError.class, () -> commandResult.getIndex());
    }

    @Test
    public void getIndex_showCommandType_EqualToIndex() {
        CommandResult commandResult = new CommandResult("feedback", SHOW, 0);
        assertEquals(0, commandResult.getIndex());
    }

    @Test
    public void getIndex_editCommandType_EqualToIndex() {
        CommandResult commandResult = new CommandResult("feedback", EDIT, 0);
        assertEquals(0, commandResult.getIndex());
    }

    @Test
    public void getIndex_assignCommandType_EqualToIndex() {
        CommandResult commandResult = new CommandResult("feedback", ASSIGN, 0);
        assertEquals(0, commandResult.getIndex());
    }

    @Test
    public void getModifiedStudent_modifiedStudent_equals() {
        CommandResult commandResult = new CommandResult("feedback", STUDENT1);
        assertEquals(STUDENT1, commandResult.getDeletedStudent());
    }

    @Test
    public void getModifiedTutor_modifiedStudent_equals() {
        CommandResult commandResult = new CommandResult("feedback", TUTOR1);
        assertEquals(TUTOR1, commandResult.getDeletedTutor());
    }

    @Test
    public void getModifiedClass_modifiedClass_equals() {
        CommandResult commandResult = new CommandResult("feedback", TUITIONCLASS1);
        assertEquals(TUITIONCLASS1, commandResult.getDeletedClass());
    }

    @Test
    public void getModifiedStudent_modifiedClass_throwsAssertionError() {
        CommandResult commandResult = new CommandResult("feedback", TUITIONCLASS1);
        assertThrows(AssertionError.class, () -> commandResult.getDeletedStudent());
    }

    @Test
    public void getModifiedTutor_modifiedStudent_throwsAssertionError() {
        CommandResult commandResult = new CommandResult("feedback", STUDENT1);
        assertThrows(AssertionError.class, () -> commandResult.getDeletedTutor());
    }

    @Test
    public void getModifiedClass_modifiedStudent_throwsAssertionError() {
        CommandResult commandResult = new CommandResult("feedback", STUDENT1);
        assertThrows(AssertionError.class, () -> commandResult.getDeletedClass());
    }

    @Test
    public void equals() {
        CommandResult commandResult = new CommandResult("feedback");

        // same values -> returns true
        assertTrue(commandResult.equals(new CommandResult("feedback")));

        // same object -> returns true
        assertTrue(commandResult.equals(commandResult));

        // null -> returns false
        assertFalse(commandResult.equals(null));

        // different types -> returns false
        assertFalse(commandResult.equals(0.5f));

        // different feedbackToUser value -> returns false
        assertFalse(commandResult.equals(new CommandResult("different")));

        // different type -> returns false
        assertFalse(commandResult.equals(new CommandResult("feedback", HELP)));

        // different show value -> returns false
        assertFalse(commandResult.equals(new CommandResult("feedback", SHOW, 0)));

        commandResult = new CommandResult("feedback", SHOW, 0);

        //different index of show command -> returns false
        assertFalse(commandResult.equals(new CommandResult("feedback", SHOW, 1)));

        // edit type CommandResult test
        CommandResult commandResultWithStudent = new CommandResult("feedback", STUDENT1);
        CommandResult commandResultWithTutor = new CommandResult("feedback", TUTOR1);
        CommandResult commandResultWithClass = new CommandResult("feedback", TUITIONCLASS1);

        // null student -> returns false
        assertFalse(commandResultWithStudent.equals(new CommandResult("feedback")));

        // null tutor -> returns false
        assertFalse(commandResultWithTutor.equals(new CommandResult("feedback")));

        // null class -> returns false
        assertFalse(commandResultWithClass.equals(new CommandResult("feedback")));

        // different student -> returns false
        assertFalse(commandResultWithStudent.equals(new CommandResult("feedback", STUDENT2)));

        // different tutor -> returns false
        assertFalse(commandResultWithTutor.equals(new CommandResult("feedback", TUTOR2)));

        // different class -> returns false
        assertFalse(commandResultWithClass.equals(new CommandResult("feedback", TUITIONCLASS2)));

        // different feedback -> returns false
        assertFalse(commandResultWithStudent.equals(new CommandResult("different", STUDENT1)));

        // different feedback -> returns false
        assertFalse(commandResultWithTutor.equals(new CommandResult("different", TUTOR2)));

        // different feedback -> returns false
        assertFalse(commandResultWithClass.equals(new CommandResult("different", TUITIONCLASS2)));
    }

    @Test
    public void hashcode() {
        CommandResult commandResult = new CommandResult("feedback");

        // same values -> returns same hashcode
        assertEquals(commandResult.hashCode(), new CommandResult("feedback").hashCode());

        // different feedbackToUser value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new CommandResult("different").hashCode());

        // different type -> returns different hashcode
        assertNotEquals(commandResult.hashCode(),
                new CommandResult("feedback", HELP).hashCode());

        // different show value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(),
                new CommandResult("feedback", SHOW, 0).hashCode());

        commandResult = new CommandResult("feedback, 1");

        //different index of show command -> returns different hashcode
        assertNotEquals(commandResult.hashCode(),
                new CommandResult("feedback", STUDENT1).hashCode());

        //different modifiedTutor -> returns different hashcode
        assertNotEquals(commandResult.hashCode(),
                new CommandResult("feedback", TUTOR1).hashCode());

        //different modifiedClass -> returns different hashcode
        assertNotEquals(commandResult.hashCode(),
                new CommandResult("feedback", TUITIONCLASS1).hashCode());
    }
}
