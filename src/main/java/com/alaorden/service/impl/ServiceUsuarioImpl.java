package com.alaorden.service.impl;

import com.alaorden.model.Usuario;
import com.alaorden.repository.RepositoryUsuario;
import com.alaorden.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuarioImpl implements ServiceUsuario {
    RepositoryUsuario repositoryUsuario;

    @Autowired
    public ServiceUsuarioImpl(RepositoryUsuario repositoryUsuario){
        this.repositoryUsuario = repositoryUsuario;
    }
    @Override
    public void Delete(Usuario entity){
        repositoryUsuario.Delete(entity);
    }
    @Override
    public void Save(Usuario entity){
        repositoryUsuario.Save(entity);
    }
    @Override
    public void Update(Usuario entity){
        repositoryUsuario.Update(entity);
    }
    @Override
    public Usuario FindById(Usuario entity){
        return repositoryUsuario.FindById(entity);
    }
    @Override
    public List<Usuario> ListAll(){
        return repositoryUsuario.ListAll();
    }

}