import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

public class PersonTest {
    AppUser user = new AppUser("Sam", "q1w2e3r4", AppRole.ROLE_APP_USER);
    Person person = new Person("Samwise", "Gamgee", "samwise.gamgee@lor.com", user);

    @Test
    @DisplayName("Create person with valid id")
    public void createPersonValidId() {
        System.out.println(person.getId());
    }

    @Test
    @DisplayName("Create person with valid firstname")
    public void createPersonValidFirstName() {
        Assertions.assertEquals("Samwise", person.getFirstName());
    }

    @Test
    @DisplayName("Create person with invalid firstname")
    public void createPersonInvalidFirstName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName(null);
            System.out.println(person.getFirstName());
        });
    }

    @Test
    @DisplayName("Create person with valid lastname")
    public void createPersonValidLastName() {
        Assertions.assertEquals("Gamgee", person.getLastName());
    }

    @Test
    @DisplayName("Create person with invalid lastname")
    public void createPersonInvalidLastName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            person.setLastName(null);
            System.out.println(person.getLastName());
        });
    }

    @Test
    @DisplayName("Create person with valid email")
    public void createPersonValidEmail() {
        Assertions.assertEquals("samwise.gamgee@lor.com", person.getEmail());
    }

    @Test
    @DisplayName("Create person with invalid email")
    public void createPersonInvalidEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            person.setEmail(null);
            System.out.println(person.getEmail());
        });
    }
}
