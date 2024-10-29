package se.lexicon.model;

import se.lexicon.util.PersonIdGenerate;

public class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email) {
        this.id = PersonIdGenerate.nextId();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
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

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(", name: ").append(firstName).append(" ").append(lastName);
        sb.append(", email: ").append(email);

        return sb.toString();
    }
}
