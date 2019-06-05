package com.alaorden.repository.impl;


import com.alaorden.repository.RepositoryUsuario;
import com.alaorden.model.Usuario;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.List;

@Component
public class RepositoryUsuarioImpl implements RepositoryUsuario {
    @Override
    public void Delete(Usuario entity){

    }
    @Override
    public void Save(Usuario entity){

    }
    @Override
    public void Update(Usuario entity){

    }
    @Override
    public Usuario FindById(Usuario entity){
        return null;
    }
    @Override
    public List<Usuario> ListAll(){
        return null;
    }
}