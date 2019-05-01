package com.myorg.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.myorg.core.entity.Usuario;
import com.myorg.core.service.impl.UsuarioServiceImpl;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.myorg.util.Message;
import org.primefaces.event.SelectEvent;


public class SessionController implements Serializable{
    
    private static Map<HttpSession,Integer> autentificados;
    @Inject
    private UsuarioServiceImpl usuarioService;
    private HttpSession session;
    
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
    
    void Autentificar(HttpServletRequest request, HttpServletResponse response, String campo, String contraseña) throws Exception{
        Integer validar = usuarioService.validarContraseña(campo, contraseña);
        if(validar == null)
            Message.messageError("Usuario no válido");
        else{
            session = request.getSession(true);
            autentificados.put(session, validar);
        }
    }
    void cerrarSesion(){
        autentificados.remove(session);
    }
    void iniciarProceso(){}
}
