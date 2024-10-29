import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;

public class TodoItemTest {
    Person samwise = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com");

    @Test
    @DisplayName("Create person with valid id")
    public void createPersonValidId() {
        TodoItem frodo = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), samwise );
        System.out.println(frodo.getId());
    }

    @Test
    @DisplayName("Create todo item with valid title")
    public void createTodoItemValidTitle() {
        TodoItem frodo = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), samwise );
        Assertions.assertEquals("Check Frodo", frodo.getTitle());
    }

    @Test
    @DisplayName("Create todo item with invalid title")
    public void createTodoItemInvalidTitle() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TodoItem frodo = new TodoItem(null, LocalDate.parse("2024-10-29"), samwise );
            System.out.println(frodo.getTitle());
        });
    }

    @Test
    @DisplayName("Create todo item with valid deadline")
    public void createTodoItemValidDeadline() {
        TodoItem frodo = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), samwise );
        Assertions.assertEquals(LocalDate.parse("2024-10-29"), frodo.getDeadLine());
    }

    @Test
    @DisplayName("Create todo item with invalid deadline")
    public void createTodoItemInvalidDeadline() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            TodoItem frodo = new TodoItem("Check Frodo", null, samwise );
            System.out.println(frodo.getDeadLine());
        });
    }

    @Test
    @DisplayName("Create todo item with valid creator")
    public void createTodoItemValidCreator() {
        TodoItem frodo = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), samwise );
        Assertions.assertEquals(samwise, frodo.getCreator());
    }

    @Test
    @DisplayName("Create todo item with invalid creator")
    public void createTodoItemInvalidCreator() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            TodoItem frodo = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), null );
            System.out.println(frodo.getCreator());
        });
    }

    @Test
    @DisplayName("Create todo item with valid done")
    public void createTodoItemValidDone() {
        TodoItem frodo = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), samwise, true );
        Assertions.assertTrue(frodo.isDone());
    }

    @Test
    @DisplayName("Create todo item with valid task description")
    public void createTodoItemValidTaskDescription() {
        TodoItem frodo = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), samwise, "Help and check his ring" );
        Assertions.assertEquals("Check Frodo", frodo.getTitle());
    }

    @Test
    @DisplayName("Create todo item with invalid task description")
    public void createTodoItemInvalidTaskDescription() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TodoItem frodo = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), samwise, null );
            System.out.println(frodo.getTaskDescription());
        });
    }

    @Test
    @DisplayName("Create todo item for check overdue task")
    public void createTodoItemIsOverdueTask() {
        TodoItem frodo = new TodoItem("Check Frodo", LocalDate.parse("2024-10-27"), samwise );
        Assertions.assertTrue(frodo.isOverdue());
    }
}
