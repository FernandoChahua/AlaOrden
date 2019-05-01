package com.myorg.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.myorg.core.entity.Usuario;
import com.myorg.core.service.impl.UsuarioServiceImpl;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.myorg.util.Message;
import org.primefaces.event.SelectEvent;


public class SessionController implements Serializable{
    private Usuario sesionActual;
    @Inject
    private UsuarioServiceImpl usuarioService;
    
    @PostConstruct
    public void init(){}
    
    void Registrar(String apodo, String email, String contraseña){
        Usuario usuario = new Usuario();
        try{
            usuario.setApodo(apodo);
            usuario.setEmail(email);
            usuario.setContrasena(contraseña);
            usuarioService.Registrar(usuario);
        }catch(Exception e){
            Message.messageError("Error Cliente" + e.getMessage());
        }
    }
    
    void cerrarSesion(){}
    void iniciarProceso(){}
}
