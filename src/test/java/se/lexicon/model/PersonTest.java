package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person testObject;
    AppUser user;

    @BeforeEach
    void setUp() {
        testObject = new Person(1);
        user = new AppUser(AppRole.ROLE_APP_USER);
    }

    @Test
    void setFirstName() {
        String testFirstName = "Karl";
        testObject.setFirstName(testFirstName);
        assertTrue(testObject.getFirstName().contains(testFirstName));
    }

    @Test
    void setLastName() {
        String testLasName = "Anderson";
        testObject.setLastName(testLasName);
        assertTrue(testObject.getLastName().contains(testLasName));
    }

    @Test
    void setEmail() {
        String testEmail = "karl@gmail.com";
        testObject.setEmail(testEmail);
        assertTrue(testObject.getEmail().contains(testEmail));
    }

    @Test
    void setCredentials() {
        testObject.setCredentials(user);
        assertEquals(testObject.getCredentials(), user);
    }
}