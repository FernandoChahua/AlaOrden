package com.alaorden.service.impl;

import com.alaorden.model.Marca;
import com.alaorden.repository.RepositoryMarca;
import com.alaorden.service.ServiceMarca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMarcaImpl implements ServiceMarca {
    RepositoryMarca repositoryMarca;

    @Autowired
    public ServiceMarcaImpl(RepositoryMarca repositoryMarca){
        this.repositoryMarca = repositoryMarca;
    }
    @Override
    public void Delete(Marca entity){
        repositoryMarca.Delete(entity);
    }
    @Override
    public void Save(Marca entity){
        repositoryMarca.Save(entity);
    }
    @Override
    public void Update(Marca entity){
        repositoryMarca.Update(entity);
    }
    @Override
    public Marca FindById(Marca entity){
        return repositoryMarca.FindById(entity);
    }
    @Override
    public List<Marca> ListAll(){
        return repositoryMarca.ListAll();
    }

}