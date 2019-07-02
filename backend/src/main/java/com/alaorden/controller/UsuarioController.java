package com.alaorden.controller;

import com.alaorden.exception.ApiException;
import com.alaorden.exception.BusinessException;
import com.alaorden.model.User;
import com.alaorden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UserService userService;

    @Autowired
    public UsuarioController(UserService userService){
        this.userService = userService;
    }


    @RequestMapping(path="/login/{nickname}/{password}",method = RequestMethod.GET)
    public User logIn(@PathVariable String nickname,@PathVariable String password){
        try {
            return userService.logIn(nickname, password);
        }
        catch (BusinessException e){
            throw new ApiException(e.getMessage(),e);
        }

    }

////////////// CRUUUD ---- USER
    @RequestMapping(method = RequestMethod.GET)
    public List<User> listAllUsers(){
        return userService.listAllUsers();
    }
    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @RequestMapping(method=RequestMethod.PUT)
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
    @RequestMapping(path="/ban/{idUser}",method=RequestMethod.PUT)
    public void banHammer(@PathVariable int idUser){
        userService.banUser(idUser);
    }
    @RequestMapping(path="/{idUser}",method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable int idUser){
        userService.deleteUser(idUser);
    }

    @RequestMapping(path="/{idUser}",method = RequestMethod.GET)
    public User findByIdUser(@PathVariable int idUser){
        return userService.findByIdUser(idUser);
    }
}
