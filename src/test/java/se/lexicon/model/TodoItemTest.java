package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {

    TodoItem testObject;
    Person person;

    @BeforeEach
    void setUp() {
        testObject = new TodoItem(1);
        person = new Person(1);
    }

    @Test
    void setTitle() {
        String testTitle = "Test";
        testObject.setTitle(testTitle);
        assertTrue(testObject.getTitle().contains(testTitle));
    }

    @Test
    void setTaskDescription() {
        String testDescription = "Test description";
        testObject.setTaskDescription(testDescription);
        assertTrue(testObject.getTaskDescription().contains(testDescription));
    }

    @Test
    void setDeadLine() {
        LocalDate testDeaLine = LocalDate.of(2024, 11, 20);
        testObject.setDeadLine(testDeaLine);
        assertEquals(testObject.getDeadLine(), testDeaLine);
    }

    @Test
    void setDone() {
        boolean done = true;
        testObject.setDone(done);
        assertEquals(testObject.isDone(), done);
    }

    @Test
    void setCreator() {
        testObject.setCreator(person);
        assertEquals(testObject.getCreator(), person);
    }

    @Test
    void isOverdue() {
        LocalDate deaLine = LocalDate.of(2024, 10, 10);
        testObject.setDeadLine(deaLine);
        assertTrue(testObject.isOverdue());
    }
}