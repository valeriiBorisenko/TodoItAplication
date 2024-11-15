package se.lexicon.data.dao;

import se.lexicon.model.Person;
import java.util.Collection;

public interface PersonDAO {
    Person persist(Person person);
    Person findById(int id);
    Person findByEmail(String email);
    Collection<Person> findByAll();
    void remove(int id);
}
