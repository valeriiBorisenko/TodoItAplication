package se.lexicon.data.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;

import static org.junit.jupiter.api.Assertions.*;

class AppUserDAOCollectionTest {

    AppUserDAO testObject;

    @BeforeEach
    void setUp() {
        testObject = new AppUserDAOCollection();
    }

    @Test
    void persist() {
        AppUser appUser = new AppUser("Karl Anderson", "q1w2e3r4", AppRole.ROLE_APP_USER);
        AppUser createdUser = testObject.persist(appUser);
        assertNotNull(createdUser);
    }

    @Test
    void findByUsername() {
        AppUser appUser = new AppUser("Karl Anderson", "q1w2e3r4", AppRole.ROLE_APP_USER);
        testObject.persist(appUser);
        assertNotNull(testObject.findByUsername("Karl Anderson"));
    }

    @Test
    void findAll() {
        AppUser appUser1 = new AppUser("Karl Anderson", "q1w2e3r4", AppRole.ROLE_APP_USER);
        AppUser appUser2 = new AppUser("Lisa Anderson", "q1w2e3r4", AppRole.ROLE_APP_USER);
        AppUser appUser3 = new AppUser("Sam Anderson", "q1w2e3r4", AppRole.ROLE_APP_USER);
        testObject.persist(appUser1);
        testObject.persist(appUser2);
        testObject.persist(appUser3);
        assertNotNull(testObject.findAll());
    }

    @Test
    void remove() {
        AppUser appUser = new AppUser("Karl Anderson", "q1w2e3r4", AppRole.ROLE_APP_USER);
        testObject.persist(appUser);
        assertNotNull(testObject.findByUsername("Karl Anderson"));
        testObject.remove("Karl Anderson");
        assertNull(testObject.findByUsername("Karl Anderson"));
    }
}