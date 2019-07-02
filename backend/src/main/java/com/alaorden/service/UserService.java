package com.alaorden.service;


import com.alaorden.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    void updateUser(User user);
    boolean existUser(User user);
    User userByNickname(String nickname);
    User logIn(String nickname, String password);
    List<User> listAllUsers();
    boolean deleteUser(int idUser);
    void banUser(int idUser);
    User findByIdUser(int idUser);
}
