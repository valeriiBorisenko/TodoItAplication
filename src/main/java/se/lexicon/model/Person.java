package se.lexicon.model;

import se.lexicon.util.PersonIdGenerate;

import java.util.Objects;

public class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    public Person(String firstName, String lastName, String email, AppUser credentials) {
        this.id = PersonIdGenerate.nextId();
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
        StringBuilder sb = new StringBuilder();
        sb.append("{id: ").append(id)
                .append(", firstName: ").append(firstName)
                .append(", lastName: ").append(lastName)
                .append(", email: ").append(email).append("}");

        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person newObj = (Person) obj;
        return id == newObj.id && Objects.equals(firstName, newObj.firstName) && Objects.equals(lastName, newObj.lastName) && Objects.equals(email, newObj.email);
    }
}
