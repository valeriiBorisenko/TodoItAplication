import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.model.*;

import java.time.LocalDate;

public class TodoItemTaskTest {
    AppUser user = new AppUser("Sam", "q1w2e3r4", AppRole.ROLE_APP_USER);
    Person samwise = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com", user);
    TodoItem frodoRing = new TodoItem("Frodo and ring", LocalDate.parse("2024-10-30"), samwise, "Check his ring", true);

    @Test
    @DisplayName("Create person with valid id")
    public void createPersonValidId() {
        TodoItemTask itemTask1 = new TodoItemTask(frodoRing);
        System.out.println(itemTask1.getId());
    }

    @Test
    @DisplayName("Create todo item with valid todo item")
    public void createTodoItemValidCreator() {
        TodoItemTask itemTask1 = new TodoItemTask(frodoRing);
        Assertions.assertEquals(frodoRing, itemTask1.getTodoItem());
    }

    @Test
    @DisplayName("Create todo item with invalid todo item")
    public void createTodoItemInvalidCreator() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            TodoItemTask itemTask1 = new TodoItemTask(null);
            System.out.println(itemTask1.getTodoItem());
        });
    }

    @Test
    @DisplayName("Create todo item with valid assignee")
    public void createTodoItemValidAssignee() {
        TodoItemTask itemTask1 = new TodoItemTask(frodoRing, samwise);
        Assertions.assertEquals(samwise, itemTask1.getAssignee());
    }

    @Test
    @DisplayName("Create todo item with invalid assignee")
    public void createTodoItemInvalidAssignee() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            TodoItemTask itemTask1 = new TodoItemTask(frodoRing, null);
            System.out.println(itemTask1.getAssignee());
        });
    }

    @Test
    @DisplayName("Create todo item with valid assigned")
    public void createTodoItemValidAssigned() {
        TodoItemTask itemTask1 = new TodoItemTask(frodoRing, samwise);
        System.out.println(itemTask1.isAssigned());
    }

    @Test
    @DisplayName("Create todo item with invalid assigned")
    public void createTodoItemInvalidAssigned() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            TodoItemTask itemTask1 = new TodoItemTask(frodoRing, null);
            System.out.println(itemTask1.isAssigned());
        });
    }
}
