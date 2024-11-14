package se.lexicon.data.dao;

import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

import java.util.Collection;

public interface PersonDAO {
    Person persist(int id, String firstName, String lastName, String email, AppUser credentials);
    Person findById(int id);
    Person findByEmail(String email);
    Collection<Person> findByAll();
    void remove(int id);
}
