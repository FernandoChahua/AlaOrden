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





    /////// ----------------- CRUD ------------------------
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

    public User findByIdUser(int idUser){
        return userRepository.findByIdUser(idUser);
    }

    @Transactional
    public boolean deleteUser(int idUser){
        User user = userRepository.findByIdUser(idUser);
        if (user == null){
            return false;
        }
        userRepository.delete(user);
        return true;
    }

    @Transactional
    public void banUser(int idUser){ // REGLA DE NEGOCIO NO ELIMINA COMPLETAMENTE SOLO CAMBIA EL ESTADO A BANEADO O DESACTIVADO
        User user = userRepository.findByIdUser(idUser);

        if(user!=null){
            user.setState(3);// ESTADO 3 <---- BAN,(2)DESACTIVADO,(1)ACTIVADO
            userRepository.save(user);
        }

    }
    @Transactional
    public void updateUser(User user) {
        if(user!=null)
        userRepository.save(user);
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


}
