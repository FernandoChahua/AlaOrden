package com.alaorden.service.impl;


import com.alaorden.exception.BusinessException;
import com.alaorden.model.Address;
import com.alaorden.model.CartItem;
import com.alaorden.model.User;
import com.alaorden.repository.UserRepository;
import com.alaorden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user) {
        User u = userRepository.findByNicknameEqualsOrEmailEquals(user.getNickname(), user.getEmail());
        if (u == null) {
            user.setEmailValidated(false);
            user.setSalt("salt");
            user.setState(1);
            userRepository.save(user);
        }
        else {

            if(u.getEmail().equalsIgnoreCase(user.getEmail())){
                throw new BusinessException("El email ya está en uso");
            }
            if(u.getNickname().equalsIgnoreCase(user.getNickname())){
                throw new BusinessException("El nickname ya existe");
            }
        }
        User userReturn = userRepository.findByNicknameEquals(user.getNickname());
        userReturn.setAddresses(null);
        userReturn.setCart(null);
        return userReturn;
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public boolean existUser(User user) {
        if (user != null) {
            User userEmail = userRepository.findByEmailEquals(user.getEmail());
            User userNickname = userRepository.findByNicknameEquals(user.getNickname());
            return !((userNickname == null) && (userEmail == null));
        }
        return false;
    }

    public User userByNickname(String nickname) {
        return userRepository.findByNicknameEquals(nickname);
    }

    public User logIn(String nickname, String password) {
        User user = userRepository.findByNicknameEqualsOrEmailEquals(nickname, nickname);
        if (user != null) {
            if (user.getHashPassword().equals(password)) {
                user.setCart(null);
                user.setAddresses(null);
                user.setHashPassword("");
            } else {
                throw new BusinessException("contraseña incorrecta");
            }
        } else {
            throw new BusinessException("usuario no existe");
        }
        return user;
    }


    public List<User> listAllUsers() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getAddresses() != null) {
                user.setAddresses(null);
            }
            if (user.getCart() != null) {
                user.setCart(null);
            }
        }
        return users;
    }
}
