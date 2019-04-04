package com.company.API.dao;

import com.company.API.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    int insertUser(UUID id, User user);

    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();

    int deleteUserById(UUID id);
    Optional<User> selectUserById(UUID id);

    int updateUserById(UUID id, User user);
}
