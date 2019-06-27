package com.alaorden.service.impl;


import com.alaorden.model.User;
import com.alaorden.repository.UserRepository;
import com.alaorden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
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

}
