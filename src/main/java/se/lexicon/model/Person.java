package se.lexicon.model;

import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    public Person(int id, String firstName, String lastName, String email, AppUser credentials) {
        this.id = id;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setCredentials(credentials);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) throw new IllegalArgumentException("Firstname should not be null or empty.");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) throw new IllegalArgumentException("Lastname should not be null or empty.");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) throw new IllegalArgumentException("Email should not be null or empty.");
        this.email = email;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        if (credentials == null) throw new IllegalArgumentException("Credentials should not be null.");
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
