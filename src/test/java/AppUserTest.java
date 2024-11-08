import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;

public class AppUserTest {
    @Test
    @DisplayName("Create user with valid userName")
    public void createAppUserValidUserName() {
        AppUser user = new AppUser("Sam", "q1w2e3r4", AppRole.ROLE_APP_USER);
        Assertions.assertEquals("Sam", user.getUsername());
    }

    @Test
    @DisplayName("Create user with invalid userName")
    public void createAppUserInvalidUserName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AppUser user = new AppUser(null, "q1w2e3r4", AppRole.ROLE_APP_USER);
            System.out.println(user.getUsername());
        });
    }

    @Test
    @DisplayName("Create user with valid password")
    public void createAppUserValidPassword() {
        AppUser user = new AppUser("Sam", "q1w2e3r4", AppRole.ROLE_APP_USER);
        Assertions.assertEquals("q1w2e3r4", user.getPassword());
    }

    @Test
    @DisplayName("Create user with invalid password")
    public void createAppUserInvalidPassword() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AppUser user = new AppUser("Sam", null, AppRole.ROLE_APP_USER);
            System.out.println(user.getPassword());
        });
    }

    @Test
    @DisplayName("Create user with valid role")
    public void createAppUserValidRole() {
        AppUser user = new AppUser("Sam", "q1w2e3r4", AppRole.ROLE_APP_USER);
        Assertions.assertEquals(AppRole.ROLE_APP_USER, user.getRole());
    }

    @Test
    @DisplayName("Create user with invalid role")
    public void createAppUserInvalidRole() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AppUser user = new AppUser("Sam", "q1w2e3r4", null);
            System.out.println(user.getRole());
        });
    }
}
