package se.lexicon.data.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
class TodoItemDAOCollectionTest {

    TodoItemDAO testObject;
    Person person;
    TodoItem todoItem;

    @BeforeEach
    void setUp() {
        testObject = new TodoItemDAOCollection();
        person = new Person(1);
        todoItem = new TodoItem("test", LocalDate.of(2024,11,13), person, true);
    }

    @Test
    void persist() {
        TodoItem createdItem = testObject.persist(todoItem);
        assertNotNull(createdItem);
    }

    @Test
    void findById() {
        testObject.persist(todoItem);
        assertNotNull(testObject.findById(todoItem.getId()));
    }

    @Test
    void findByAll() {
        TodoItem todoItem2 = new TodoItem(2);
        testObject.persist(todoItem);
        testObject.persist(todoItem2);
        assertNotNull(testObject.findByAll());
    }

    @Test
    void findByAllDoneStatus() {
        TodoItem todoItem1 = new TodoItem("test2", LocalDate.of(2024,10,15), person, true);
        TodoItem todoItem2 = new TodoItem("test false", LocalDate.of(2024,10,15), person);
        testObject.persist(todoItem);
        testObject.persist(todoItem1);
        testObject.persist(todoItem2);
        HashSet<TodoItem> doneItems = new HashSet<>(testObject.findByAllDoneStatus(true));
        assertNotNull(doneItems);
        for (TodoItem item: doneItems) {
            assertTrue(item.isDone());
            System.out.println(item);
        }
    }

    @Test
    void findByTitleContains() {
        TodoItem todoItem1 = new TodoItem("test2", LocalDate.of(2024,10,15), person, true);
        TodoItem todoItem2 = new TodoItem("New", LocalDate.of(2024,10,15), person);
        testObject.persist(todoItem);
        testObject.persist(todoItem1);
        testObject.persist(todoItem2);

        HashSet<TodoItem> titleContainsItems = new HashSet<>(testObject.findByTitleContains(todoItem.getTitle().trim().toLowerCase()));
        assertNotNull(titleContainsItems);
        for (TodoItem item: titleContainsItems){
            assertTrue(item.getTitle().trim().toLowerCase().contains(todoItem.getTitle().trim().toLowerCase()));
            System.out.println(item.getTitle());
        }
    }

    @Test
    void findByPersonId() {
        Person person1 = new Person(2);
        TodoItem todoItem1 = new TodoItem("test2", LocalDate.of(2024,10,15), person);
        TodoItem todoItem2 = new TodoItem("test2", LocalDate.of(2024,10,15), person1);
        testObject.persist(todoItem);
        testObject.persist(todoItem1);
        testObject.persist(todoItem2);

        HashSet<TodoItem> personIdItems = new HashSet<>(testObject.findByPersonId(person.getId()));
        assertNotNull(personIdItems);
        for (TodoItem item: personIdItems){
            assertEquals(item.getCreator().getId(), person.getId());
            System.out.println(item.getCreator());
        }
    }

    @Test
    void findByDeadlineBefore() {
        LocalDate deadLine = LocalDate.of(2024,10,15);
        TodoItem todoItem1 = new TodoItem("test1", LocalDate.of(2024,10,12), person);
        TodoItem todoItem2 = new TodoItem("test2", LocalDate.of(2024,10,17), person);
        testObject.persist(todoItem);
        testObject.persist(todoItem1);
        testObject.persist(todoItem2);

        HashSet<TodoItem> deadlineBeforeItems = new HashSet<>(testObject.findByDeadlineBefore(deadLine));
        assertNotNull(deadlineBeforeItems);
        for (TodoItem item: deadlineBeforeItems){
            assertTrue(item.getDeadLine().isBefore(deadLine));
            System.out.println(item.getDeadLine());
        }
    }

    @Test
    void findByDeadlineAfter() {
        LocalDate deadLine = LocalDate.of(2024,10,15);
        TodoItem todoItem1 = new TodoItem("test1", LocalDate.of(2024,10,12), person);
        TodoItem todoItem2 = new TodoItem("test2", LocalDate.of(2024,10,17), person);
        testObject.persist(todoItem);
        testObject.persist(todoItem1);
        testObject.persist(todoItem2);

        HashSet<TodoItem> deadlineAfterItems = new HashSet<>(testObject.findByDeadlineAfter(deadLine));
        assertNotNull(deadlineAfterItems);
        for (TodoItem item: deadlineAfterItems){
            assertTrue(item.getDeadLine().isAfter(deadLine));
            System.out.println(item.getDeadLine());
        }
    }

    @Test
    void remove() {
        testObject.persist(todoItem);
        assertNotNull(testObject.findById(todoItem.getId()));
        testObject.remove(todoItem.getId());
        assertNull(testObject.findById(todoItem.getId()));
    }
}