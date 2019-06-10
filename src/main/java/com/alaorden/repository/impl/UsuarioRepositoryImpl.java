package com.alaorden.repository.impl;


import com.alaorden.repository.UsuarioRepository;
import com.alaorden.model.Usuario;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class UsuarioRepositoryImpl implements UsuarioRepository {
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