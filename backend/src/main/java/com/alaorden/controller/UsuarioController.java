package com.alaorden.controllers;

import com.alaorden.model.CartItem;
import com.alaorden.model.User;
import com.alaorden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    UserService userService;

    @Autowired
    public UsuarioController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(path="/create",method = RequestMethod.POST)
    User createUser(@RequestBody User user){
        if(!userService.existUser(user)){
            user.setCart(new ArrayList<>());
            user.setAddresses(new ArrayList<>());
            user.setEmailValidated(false);
            user.setSalt("SALSITA PAL CUERPO");
            userService.createUser(user);
        }else{
            user.setNickname("NO EXISTE USUARIO");
        }
        return user;
    }

    @RequestMapping(path="/update/{id}",method=RequestMethod.PUT)
    User updateUser(@PathVariable int id,@RequestBody User user){
        user.setIdUser(id);
        userService.updateUser(user);
        return user;
    }

    @RequestMapping(path="/login",method = RequestMethod.GET)
    User logIn(@RequestBody User user){
        User userBackend = userService.userByNickname(user.getNickname());
        if(userBackend != null) {
            if(userBackend.getHashPassword() == user.getHashPassword()){
                return userBackend;
            }
        }
        return null;
    }
}
