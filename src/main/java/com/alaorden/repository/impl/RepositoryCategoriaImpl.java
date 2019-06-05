package com.alaorden.repository.impl;

import com.alaorden.repository.RepositoryCategoria;
import com.alaorden.model.Categoria;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.List;

@Component
public class RepositoryCategoriaImpl implements RepositoryCategoria {
    @Override
    public void Delete(Categoria entity){

    }
    @Override
    public void Save(Categoria entity){

    }
    @Override
    public void Update(Categoria entity){

    }
    @Override
    public Categoria FindById(Categoria entity){
        return null;
    }
    @Override
    public List<Categoria> ListAll(){
        return null;
    }
}