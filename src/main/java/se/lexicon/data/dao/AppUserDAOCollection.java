package se.lexicon.data.dao;

import se.lexicon.data.sequencers.PersonIdSequencer;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;

import java.util.Collection;
import java.util.Collections;

public class AppUserDAOCollection implements AppUserDAO {

    private Collection<AppUser> users;

    public AppUserDAOCollection(Collection<AppUser> users) {
        this.users = users;
    }


    @Override
    public AppUser persist(String username, String password, AppRole role) {
        AppUser newUser = new AppUser(username, password, role);

        return users.add(newUser) ? newUser : null;
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
