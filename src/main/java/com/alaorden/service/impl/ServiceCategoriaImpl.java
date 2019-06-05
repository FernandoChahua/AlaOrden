package com.alaorden.service.impl;

import com.alaorden.model.Categoria;
import com.alaorden.repository.RepositoryCategoria;
import com.alaorden.service.ServiceCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategoriaImpl implements ServiceCategoria {
    RepositoryCategoria repositoryCategoria;

    @Autowired
    public ServiceCategoriaImpl(RepositoryCategoria repositoryCategoria){
        this.repositoryCategoria = repositoryCategoria;
    }
    @Override
    public void Delete(Categoria entity){
        repositoryCategoria.Delete(entity);
    }
    @Override
    public void Save(Categoria entity){
        repositoryCategoria.Save(entity);
    }
    @Override
    public void Update(Categoria entity){
        repositoryCategoria.Update(entity);
    }
    @Override
    public Categoria FindById(Categoria entity){
        return repositoryCategoria.FindById(entity);
    }
    @Override
    public List<Categoria> ListAll(){
        return repositoryCategoria.ListAll();
    }

}