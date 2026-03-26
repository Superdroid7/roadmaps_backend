package co.com.ias.roadmap.repository;



import co.com.ias.roadmap.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();

        users.add(new User(1, "Jutrululu","juliana@ias.com", "1345", 2));
        users.add(new User(1, "Superdroid","samuel@ias.com", "admin", 1));
    }

    public User authenticateUSer(String username, String password){
        for (User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
