import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

public class PersonTest {
    AppUser user = new AppUser("Sam", "q1w2e3r4", AppRole.ROLE_APP_USER);

    @Test
    @DisplayName("Create person with valid id")
    public void createPersonValidId() {
        Person samwise = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com", user);
        System.out.println(samwise.getId());
    }

    @Test
    @DisplayName("Create person with valid firstname")
    public void createPersonValidFirstName() {
        Person samwise = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com", user);
        Assertions.assertEquals("Samwise", samwise.getFirstName());
    }

    @Test
    @DisplayName("Create person with invalid firstname")
    public void createPersonInvalidFirstName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Person samwise = new Person(null, "Gamgee", "samwise.gamgee@lor.com", user);
            System.out.println(samwise.getFirstName());
        });
    }

    @Test
    @DisplayName("Create person with valid lastname")
    public void createPersonValidLastName() {
        Person samwise = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com", user);
        Assertions.assertEquals("Gamgee", samwise.getLastName());
    }

    @Test
    @DisplayName("Create person with invalid lastname")
    public void createPersonInvalidLastName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Person samwise = new Person("Samwise", null, "samwise.gamgee@lor.com", user);
            System.out.println(samwise.getLastName());
        });
    }

    @Test
    @DisplayName("Create person with valid email")
    public void createPersonValidEmail() {
        Person samwise = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com", user);
        Assertions.assertEquals("samwise.gamgee@lor.com", samwise.getEmail());
    }

    @Test
    @DisplayName("Create person with invalid email")
    public void createPersonInvalidEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Person samwise = new Person("Samwise", "Gamgee", null, user);
            System.out.println(samwise.getEmail());
        });
    }
}
