package se.lexicon.data.dao;

import se.lexicon.model.AppUser;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class AppUserDAOCollection implements AppUserDAO {

    private Collection<AppUser> users;

    public AppUserDAOCollection() {
        this.users = new HashSet<>();
    }

    public AppUserDAOCollection(Collection<AppUser> users) {
        this.users = new HashSet<>(users);
    }

    @Override
    public AppUser persist(AppUser appUser) {
        return users.add(appUser) ? appUser : null;
    }

    @Override
    public AppUser findByUsername(String username) {
        for (AppUser user: users) {
            if (user.getUsername().trim().toLowerCase().contains(username.trim().toLowerCase())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return Collections.unmodifiableCollection(users);
    }

    @Override
    public void remove(String username) {
        users.remove(findByUsername(username));
    }
}
