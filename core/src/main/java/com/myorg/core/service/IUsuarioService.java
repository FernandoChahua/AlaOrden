package com.myorg.core.service;

import com.myorg.core.entity.Usuario;

public interface IUsuarioService extends ICrudService<Usuario> {
    Integer validarContraseña(String campo, String contraseña);
    boolean Registrar(Usuario usuario) throws Exception;
    Usuario findByApodo(String apodo);
    Usuario findByEmail(String email);
}
