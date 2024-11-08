package se.lexicon.model;

public enum AppRole {

    ROLE_APP_USER("user"),
    ROLE_APP_ADMIN("admin");

    private final String role;

    AppRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
