package com.myorg.core.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.impl.*;
import javax.transaction.Transactional;
import com.myorg.core.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService {

    @Inject
    private UsuarioRepositoryImpl usuarioRepository;

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
