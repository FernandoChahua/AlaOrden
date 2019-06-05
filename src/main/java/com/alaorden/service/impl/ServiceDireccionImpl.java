package com.alaorden.service.impl;

import com.alaorden.model.Direccion;
import com.alaorden.repository.RepositoryDireccion;
import com.alaorden.service.ServiceDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDireccionImpl implements ServiceDireccion {
    RepositoryDireccion repositoryDireccion;

    @Autowired
    public ServiceDireccionImpl(RepositoryDireccion repositoryDireccion){
        this.repositoryDireccion = repositoryDireccion;
    }
    @Override
    public void Delete(Direccion entity){
        repositoryDireccion.Delete(entity);
    }
    @Override
    public void Save(Direccion entity){
        repositoryDireccion.Save(entity);
    }
    @Override
    public void Update(Direccion entity){
        repositoryDireccion.Update(entity);
    }
    @Override
    public Direccion FindById(Direccion entity){
        return repositoryDireccion.FindById(entity);
    }
    @Override
    public List<Direccion> ListAll(){
        return repositoryDireccion.ListAll();
    }

}