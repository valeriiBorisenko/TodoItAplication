package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {
    TodoItemTask testObject;
    Person person;
    TodoItem item;

    @BeforeEach
    void setUp() {
        testObject = new TodoItemTask(1);
        person = new Person(1);
        item = new TodoItem(1);
    }

    @Test
    void setTodoItem() {
        testObject.setTodoItem(item);
        assertEquals(testObject.getTodoItem(), item);
    }

    @Test
    void setAssignee() {
        testObject.setAssignee(person);
        assertEquals(testObject.getAssignee(), person);
    }

    @Test
    void setAssigned() {
        assertFalse(testObject.isAssigned());
        testObject.setAssignee(person);
        assertTrue(testObject.isAssigned());
    }
}