package com.myorg.core.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.IUsuarioRepository;
import com.myorg.core.repository.IRolRepository;
import com.myorg.core.entity.Rol;
import javax.transaction.Transactional;
import com.myorg.core.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService {

    private static final long serialVersionUID = 1L;

    @Inject
    private IUsuarioRepository usuarioRepository;
    
    @Inject
    private IRolRepository rolRepository;

    
    //param: usuario (puede contener apodo o email en el atributo apodo)
    @Override
    public Usuario validarContraseña(Usuario usuario){
        Usuario rpta = usuarioRepository.findByApodo(usuario.getApodo());
        if(rpta.getIdUsuario() != null){
            if(rpta.getContrasena().equals(usuario.getContrasena())){
                return rpta;
            }
            else rpta = null;
        }
        else
            rpta = null;
        return rpta;
    }
    
    @Override
    @Transactional
    public boolean Registrar(Usuario usuario) throws Exception {
        boolean rpta = false;
        if(usuarioRepository.findByEmail(usuario.getEmail()).getIdUsuario() == null ||
                usuarioRepository.findByApodo(usuario.getApodo()).getIdUsuario() == null){
            rpta = usuarioRepository.insert(usuario);
        }
        return rpta;
    }
    //Registrar como String para enviar un mensaje en caso lo repetido sea el usuario o la contraseña
    
    @Override
    public Usuario findByApodo(String apodo) {
        return usuarioRepository.findByApodo(apodo);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    @Override
    @Transactional
    public boolean insert(Usuario u) throws Exception {
        return usuarioRepository.insert(u);
    }

    @Override
    @Transactional
    public boolean update(Usuario u) throws Exception {
        return usuarioRepository.update(u);
    }

    @Override
    @Transactional
    public boolean delete(Usuario u) throws Exception {
        return usuarioRepository.delete(u);
    }

    @Override
    public Usuario findById(Usuario u) throws Exception {
        return usuarioRepository.findById(u);
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        return usuarioRepository.findAll();
    }

    

}
