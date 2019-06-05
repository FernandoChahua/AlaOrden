package com.alaorden.controllers;
import com.alaorden.model.Usuario;
import com.alaorden.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    ServiceUsuario serviceUsuario;

    @Autowired
    public UsuarioController(ServiceUsuario serviceUsuario){
        this.serviceUsuario = serviceUsuario;
    }
    @RequestMapping
    List<Usuario> ListUsuario(){
        return serviceUsuario.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Usuario FindById(@PathVariable int id){
        return serviceUsuario.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Usuario createUsuario(@RequestBody Usuario entity){
        return null;
    }

}
