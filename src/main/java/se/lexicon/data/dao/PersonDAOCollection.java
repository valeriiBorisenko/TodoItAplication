package se.lexicon.data.dao;

import se.lexicon.data.sequencers.PersonIdSequencer;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

import java.util.Collection;
import java.util.Collections;

public class PersonDAOCollection implements PersonDAO{

    private Collection<Person> persons;

    public PersonDAOCollection(Collection<Person> persons) {
        this.persons = persons;
    }

    @Override
    public Person persist(int id, String firstName, String lastName, String email, AppUser credentials) {
        Person newPerson = new Person(PersonIdSequencer.nextId(), firstName, lastName, email, credentials);

        return persons.add(newPerson) ? newPerson : null;
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
