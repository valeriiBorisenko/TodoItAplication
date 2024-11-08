import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;

public class AppUserTest {
    AppUser user = new AppUser("Sam", "q1w2e3r4", AppRole.ROLE_APP_USER);

    @Test
    @DisplayName("Create user with valid userName")
    public void createAppUserValidUserName() {
        Assertions.assertEquals("Sam", user.getUsername());
    }

    @Test
    @DisplayName("Create user with invalid userName")
    public void createAppUserInvalidUserName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUsername(null);
            System.out.println(user.getUsername());
        });
    }

    @Test
    @DisplayName("Create user with valid password")
    public void createAppUserValidPassword() {
        Assertions.assertEquals("q1w2e3r4", user.getPassword());
    }

    @Test
    @DisplayName("Create user with invalid password")
    public void createAppUserInvalidPassword() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setPassword(null);
            System.out.println(user.getPassword());
        });
    }

    @Test
    @DisplayName("Create user with valid role")
    public void createAppUserValidRole() {
        Assertions.assertEquals(AppRole.ROLE_APP_USER, user.getRole());
    }

    @Test
    @DisplayName("Create user with invalid role")
    public void createAppUserInvalidRole() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setRole(null);
            System.out.println(user.getRole());
        });
    }
}
