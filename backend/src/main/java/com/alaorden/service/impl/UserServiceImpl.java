package com.alaorden.service.impl;


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
    public UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public String createUser(User user){
        User u = userRepository.findByNicknameEqualsOrEmailEquals(user.getNickname(),user.getEmail());
        if(u==null){
            user.setEmailValidated(false);
            user.setSalt("salt");
            user.setState(1);
            userRepository.save(user);
            return "Registrado Correctamente";
        }

        if(u.getNickname().equals(user.getNickname()) && u.getEmail().equals(user.getEmail())){
                return "El nickname y email ya existe";
        }
        if(u.getNickname().equals(user.getNickname())){
            return "El nickname ya existe";
        }
        return "El email ya existe";

    }
    public User updateUser(User user){
        return userRepository.save(user);
    }
    public boolean existUser(User user){
        if(user!=null) {
            User userEmail = userRepository.findByEmailEquals(user.getEmail());
            User userNickname = userRepository.findByNicknameEquals(user.getNickname());
            return !((userNickname == null) && (userEmail == null));
        }
        return false;
    }
    public User userByNickname(String nickname){
        return userRepository.findByNicknameEquals(nickname);
    }
    public String logIn(String nickname, String password){
        User user = userRepository.findByNicknameEqualsOrEmailEquals(nickname,nickname);
        if(user!=null){
            if(user.getHashPassword().equals(password))
            {
                return "Logeado";
            }else{
                return "Contraseña Incorrecta";
            }
        }

        return "El usuario no existe";
    }


    public List<User> listAllUsers() {
        List<User> users = userRepository.findAll();
        for(User user : users){
            if(user.getAddresses()!=null){
                user.setAddresses(null);
            }
            if(user.getCart()!=null){
                user.setCart(null);
            }
        }
        return users;
    }
}
