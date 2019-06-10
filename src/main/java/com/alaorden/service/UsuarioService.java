package com.alaorden.service;


import com.alaorden.model.Usuario;

public interface UsuarioService {

    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    boolean existeUsuario(String apodo,String hashPassword);

}
