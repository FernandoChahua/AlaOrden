package com.alaorden.controllers;
import com.alaorden.model.Usuario;
import com.alaorden.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @RequestMapping
    List<Usuario> ListUsuario(){
        return usuarioService.ListAll();
    }
    @RequestMapping(path="/{id)",method = RequestMethod.GET)
    Usuario FindById(@PathVariable int id){
        return usuarioService.FindById(null);
    }
    @RequestMapping(method=RequestMethod.POST)
    Usuario createUsuario(@RequestBody Usuario entity){
        return null;
    }

}
