import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;

public class TodoItemTest {
    AppUser user = new AppUser("Sam", "q1w2e3r4", AppRole.ROLE_APP_USER);
    Person person = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com", user);
    TodoItem item = new TodoItem("Check Frodo", LocalDate.parse("2024-10-29"), person, "Help and check his ring", true );

    @Test
    @DisplayName("Create person with valid id")
    public void createPersonValidId() {
        System.out.println(item.getId());
    }

    @Test
    @DisplayName("Create todo item with valid title")
    public void createTodoItemValidTitle() {
        Assertions.assertEquals("Check Frodo", item.getTitle());
    }

    @Test
    @DisplayName("Create todo item with invalid title")
    public void createTodoItemInvalidTitle() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            item.setTitle(null);
            System.out.println(item.getTitle());
        });
    }

    @Test
    @DisplayName("Create todo item with valid deadline")
    public void createTodoItemValidDeadline() {
        Assertions.assertEquals(LocalDate.parse("2024-10-29"), item.getDeadLine());
    }

    @Test
    @DisplayName("Create todo item with invalid deadline")
    public void createTodoItemInvalidDeadline() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            item.setDeadLine(null);
            System.out.println(item.getDeadLine());
        });
    }

    @Test
    @DisplayName("Create todo item with valid creator")
    public void createTodoItemValidCreator() {

        Assertions.assertEquals(person, item.getCreator());
    }

    @Test
    @DisplayName("Create todo item with invalid creator")
    public void createTodoItemInvalidCreator() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            item.setCreator(null);
            System.out.println(item.getCreator());
        });
    }

    @Test
    @DisplayName("Create todo item with valid done")
    public void createTodoItemValidDone() {
        Assertions.assertTrue(item.isDone());
    }

    @Test
    @DisplayName("Create todo item with valid task description")
    public void createTodoItemValidTaskDescription() {
        Assertions.assertEquals("Check Frodo", item.getTitle());
    }

    @Test
    @DisplayName("Create todo item with invalid task description")
    public void createTodoItemInvalidTaskDescription() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            item.setTaskDescription(null);
            System.out.println(item.getTaskDescription());
        });
    }

    @Test
    @DisplayName("Create todo item for check overdue task")
    public void createTodoItemIsOverdueTask() {
        Assertions.assertTrue(item.isOverdue());
    }
}
