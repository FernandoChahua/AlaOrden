package com.alaorden.controllers;

import com.alaorden.model.CarritoItem;
import com.alaorden.model.Usuario;
import com.alaorden.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @RequestMapping(path="/create",method = RequestMethod.POST)
    Usuario createUsuario(@RequestBody Usuario usuario){
        if(!usuarioService.existeUsuario(usuario)){
            usuario.setCarrito(new ArrayList<>());
            usuario.setDirecciones(new ArrayList<>());
            usuario.setEmailValidado(false);
            usuario.setSal("SALSITA PAL CUERPO");
            usuarioService.createUsuario(usuario);
        }else{
            usuario.setApodo("EXISTE USUARIO");
        }
        return usuario;
    }

    @RequestMapping(path="/update/{id}",method=RequestMethod.PUT)
    Usuario updateUsuario(@PathVariable int id,@RequestBody Usuario usuario){
        usuario.setIdUsuario(id);
        usuarioService.updateUsuario(usuario);
        return usuario;
    }

    @RequestMapping(path="/login",method = RequestMethod.GET)
    Usuario logIn(@RequestBody Usuario usuario){
        Usuario usuarioBackend = usuarioService.usuarioByApodo(usuario.getApodo());
        if(usuarioBackend != null) {
            if(usuarioBackend.getHashContrasena() == usuario.getHashContrasena()){
                return usuarioBackend;
            }
        }
        return null;
    }
}
