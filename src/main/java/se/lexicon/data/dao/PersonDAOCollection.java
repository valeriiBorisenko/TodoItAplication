package se.lexicon.data.dao;

import se.lexicon.model.Person;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class PersonDAOCollection implements PersonDAO{

    private Collection<Person> persons;

    public PersonDAOCollection() {
        this.persons = new HashSet<>();
    }

    public PersonDAOCollection(Collection<Person> persons) {
        this.persons = new HashSet<>(persons);
    }

    @Override
    public Person persist(Person person) {
        return persons.add(person) ? person : null;
    }

    @Override
    public Person findById(int id) {
        for (Person person: persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person: persons) {
            if (person.getEmail().trim().toLowerCase().contains(email.trim().toLowerCase())) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findByAll() {
        return Collections.unmodifiableCollection(persons);
    }

    @Override
    public void remove(int id) {
        persons.remove(findById(id));
    }
}
