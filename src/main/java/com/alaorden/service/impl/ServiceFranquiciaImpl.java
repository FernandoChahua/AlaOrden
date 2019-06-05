package com.alaorden.service.impl;

import com.alaorden.model.Franquicia;
import com.alaorden.repository.RepositoryFranquicia;
import com.alaorden.service.ServiceFranquicia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFranquiciaImpl implements ServiceFranquicia {
    RepositoryFranquicia repositoryFranquicia;

    @Autowired
    public ServiceFranquiciaImpl(RepositoryFranquicia repositoryFranquicia){
        this.repositoryFranquicia = repositoryFranquicia;
    }
    @Override
    public void Delete(Franquicia entity){
        repositoryFranquicia.Delete(entity);
    }
    @Override
    public void Save(Franquicia entity){
        repositoryFranquicia.Save(entity);
    }
    @Override
    public void Update(Franquicia entity){
        repositoryFranquicia.Update(entity);
    }
    @Override
    public Franquicia FindById(Franquicia entity){
        return repositoryFranquicia.FindById(entity);
    }
    @Override
    public List<Franquicia> ListAll(){
        return repositoryFranquicia.ListAll();
    }

}