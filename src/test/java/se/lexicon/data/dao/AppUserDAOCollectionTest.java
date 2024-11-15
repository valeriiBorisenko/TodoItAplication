package se.lexicon.data.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;

import static org.junit.jupiter.api.Assertions.*;

class AppUserDAOCollectionTest {

    AppUserDAO testObject;
    AppUser appUser;

    @BeforeEach
    void setUp() {
        testObject = new AppUserDAOCollection();
        appUser = new AppUser("Karl Anderson", "q1w2e3r4", AppRole.ROLE_APP_USER);
    }

    @Test
    void persist() {
        AppUser createdUser = testObject.persist(appUser);
        assertNotNull(createdUser);
    }

    @Test
    void findByUsername() {
        testObject.persist(appUser);
        assertNotNull(testObject.findByUsername(appUser.getUsername()));
    }

    @Test
    void findAll() {
        AppUser appUser2 = new AppUser("Lisa Anderson", "q1w2e3r4", AppRole.ROLE_APP_USER);
        testObject.persist(appUser);
        testObject.persist(appUser2);
        assertNotNull(testObject.findAll());
    }

    @Test
    void remove() {
        testObject.persist(appUser);
        assertNotNull(testObject.findByUsername(appUser.getUsername()));
        testObject.remove(appUser.getUsername());
        assertNull(testObject.findByUsername(appUser.getUsername()));
    }
}