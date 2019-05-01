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

    @Override
    public boolean validarContraseña(String campo, String contraseña){
        boolean rpta = false;
        if(usuarioRepository.findByEmail(campo).getIdUsuario() != null){
            if(usuarioRepository.findByEmail(campo).getContrasena() == contraseña){
                rpta = true;
            }
        }
        else{
            if(usuarioRepository.findByApodo(campo).getIdUsuario() != null){
                if(usuarioRepository.findByApodo(campo).getContrasena() == contraseña){
                    rpta = true;
                }
            }
        }
        return rpta;
    }
    
    @Override
    public boolean Registrar(Usuario usuario) throws Exception {
        boolean rpta = false;
        Rol r = new Rol();
        if(usuarioRepository.findByEmail(usuario.getEmail()).getIdUsuario() == null ||
                usuarioRepository.findByApodo(usuario.getApodo()).getIdUsuario() == null){
            r.setNombre("cliente");
            r = rolRepository.findByNombre(r);
            usuario.getRoles().add(r);
            rpta = usuarioRepository.insert(usuario);
        }
        return rpta;
    }
    
    //Registrar como String para enviar un mensaje en caso lo repetido sea el usuario o la contraseña
    
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
