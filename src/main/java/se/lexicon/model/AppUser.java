package se.lexicon.model;

import java.util.Objects;

public class AppUser {
    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) throw new IllegalArgumentException("Username should not be null or empty.");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) throw new IllegalArgumentException("Password should not be null or empty.");
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if (role == null) throw new IllegalArgumentException("Role should not be null.");
        this.role = role;
    }


    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AppUser newObj = (AppUser) obj;
        return Objects.equals(username, newObj.username) && role == newObj.role;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{username: ").append(this.username).append(", role: ").append(this.role.getRole()).append("}");
        return sb.toString();
    }
}
