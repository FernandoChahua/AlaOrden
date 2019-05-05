package com.myorg.core.service;

import com.myorg.core.entity.Usuario;

public interface IUsuarioService extends ICrudService<Usuario> {
    public Usuario validarContraseña(Usuario usuario);
    boolean Registrar(Usuario usuario) throws Exception;
    Usuario findByApodo(String apodo);
    Usuario findByEmail(String email);
}
