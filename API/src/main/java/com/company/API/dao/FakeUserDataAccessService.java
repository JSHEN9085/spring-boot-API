package com.company.API.dao;

import com.company.API.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FakeUserDataAccessService implements UserDao {
    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getName()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> maybeUser = selectUserById(id);
        if(maybeUser.isEmpty()){
            return 0;
        }
        DB.remove(maybeUser.get());
        return 1;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public int updateUserById(UUID id, User user) {
        return selectUserById(id).map( u -> {
            int indexOfUserToDelete = DB.indexOf(u);
            if(indexOfUserToDelete >= 0){
                DB.set(indexOfUserToDelete, u);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
