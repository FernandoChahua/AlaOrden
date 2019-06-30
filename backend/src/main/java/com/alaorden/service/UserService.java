package com.alaorden.service;


import com.alaorden.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    boolean existUser(User user);
    User userByNickname(String nickname);
    User logIn(String nickname, String password);
    List<User> listAllUsers();
}
