package com.alaorden.service.impl;

import com.alaorden.model.Usuario;
import com.alaorden.repository.UsuarioRepository;
import com.alaorden.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public void Delete(Usuario entity){
        usuarioRepository.Delete(entity);
    }
    @Override
    public void Save(Usuario entity){
        usuarioRepository.Save(entity);
    }
    @Override
    public void Update(Usuario entity){
        usuarioRepository.Update(entity);
    }
    @Override
    public Usuario FindById(Usuario entity){
        return usuarioRepository.FindById(entity);
    }
    @Override
    public List<Usuario> ListAll(){
        return usuarioRepository.ListAll();
    }

}