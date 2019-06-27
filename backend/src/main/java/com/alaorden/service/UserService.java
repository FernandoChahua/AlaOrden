package com.alaorden.service;


import com.alaorden.model.User;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    boolean existUser(User user);
    User userByNickname(String nickname);
}
