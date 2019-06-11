package com.alaorden.service.impl;


import com.alaorden.model.Usuario;
import com.alaorden.repository.UsuarioRepository;
import com.alaorden.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    public UsuarioRepository usuarioRepository;

    @Autowired
    public  UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario createUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public boolean existeUsuario(Usuario usuario){
        if(usuario!=null) {
            Usuario usuarioEmail = usuarioRepository.findByEmailEquals(usuario.getEmail());
            Usuario usuarioApodo = usuarioRepository.findByApodoEquals(usuario.getApodo());
            return !((usuarioApodo == null) && (usuarioEmail == null));
        }
        return false;
    }

}
