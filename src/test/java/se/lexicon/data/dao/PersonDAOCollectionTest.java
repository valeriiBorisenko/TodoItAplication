package se.lexicon.data.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOCollectionTest {

    PersonDAO testObject;
    AppUser user;
    Person person;

    @BeforeEach
    void setUp() {
        testObject = new PersonDAOCollection();
        user = new AppUser(AppRole.ROLE_APP_USER);
        person = new Person("Karl", "Anderson", "karl@gmail.com", user);
    }

    @Test
    void persist() {
        Person createdPerson = testObject.persist(person);
        assertNotNull(createdPerson);
    }

    @Test
    void findById() {
        Person newPerson = new Person(1);
        testObject.persist(newPerson);
        assertNotNull(testObject.findById(newPerson.getId()));
    }

    @Test
    void findByEmail() {
        testObject.persist(person);
        assertNotNull(testObject.findByEmail(person.getEmail()));
    }

    @Test
    void findByAll() {
        Person person2 = new Person(2);
        testObject.persist(person);
        testObject.persist(person2);
        assertNotNull(testObject.findByAll());
    }

    @Test
    void remove() {
        testObject.persist(person);
        assertNotNull(testObject.findById(person.getId()));
        testObject.remove(person.getId());
        assertNull(testObject.findById(person.getId()));
    }
}