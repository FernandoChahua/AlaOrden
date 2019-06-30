package com.alaorden.controller;

import com.alaorden.exception.ApiException;
import com.alaorden.exception.BusinessException;
import com.alaorden.model.CartItem;
import com.alaorden.model.User;
import com.alaorden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    UserService userService;

    @Autowired
    public UsuarioController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<User> listAllUsers(){
        return userService.listAllUsers();
    }
    @RequestMapping(method = RequestMethod.POST)
    User createUser(@RequestBody User user){
      return userService.createUser(user);
    }

    @RequestMapping(path="/update/{id}",method=RequestMethod.PUT)
    User updateUser(@PathVariable int id,@RequestBody User user){
        user.setIdUser(id);
        userService.updateUser(user);
        return user;
    }

    @RequestMapping(path="/login/{nickname}/{password}",method = RequestMethod.GET)
    User logIn(@PathVariable String nickname,@PathVariable String password){
        try {
            return userService.logIn(nickname, password);
        }
        catch (BusinessException e){
            throw new ApiException(e.getMessage(),e);
        }

    }
}
