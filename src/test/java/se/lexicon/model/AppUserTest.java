package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    AppUser testObject;

    @BeforeEach
    void setUp() {
        testObject = new AppUser();
    }

    @Test
    void setUsername() {
        String testName = "Karl Anderson";
        testObject.setUsername(testName);
        assertTrue(testObject.getUsername().contains(testName));
    }

    @Test
    void setPassword() {
        String testPassword = "q1w2e3";
        testObject.setPassword(testPassword);
        assertTrue(testObject.getPassword().contains(testPassword));
    }

    @Test
    void setRole() {
        AppRole role = AppRole.ROLE_APP_USER;
        testObject.setRole(role);
        assertSame(testObject.getRole(), role);
    }
}