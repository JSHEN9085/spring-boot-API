package com.company.API.api;
import com.company.API.model.User;
import com.company.API.service.UserService;

public class UserControllor {

    private final UserService userService;

    public UserControllor(UserService userService) {
        this.userService = userService;
    }

    public void addUser(User user){
        userService.addUser(user);
    }
}
