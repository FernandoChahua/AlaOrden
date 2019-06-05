package com.alaorden.service.impl;

import com.alaorden.model.Transaccion;
import com.alaorden.repository.RepositoryTransaccion;
import com.alaorden.service.ServiceTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTransaccionImpl implements ServiceTransaccion {
    RepositoryTransaccion repositoryTransaccion;

    @Autowired
    public ServiceTransaccionImpl(RepositoryTransaccion repositoryTransaccion){
        this.repositoryTransaccion = repositoryTransaccion;
    }
    @Override
    public void Delete(Transaccion entity){
        repositoryTransaccion.Delete(entity);
    }
    @Override
    public void Save(Transaccion entity){
        repositoryTransaccion.Save(entity);
    }
    @Override
    public void Update(Transaccion entity){
        repositoryTransaccion.Update(entity);
    }
    @Override
    public Transaccion FindById(Transaccion entity){
        return repositoryTransaccion.FindById(entity);
    }
    @Override
    public List<Transaccion> ListAll(){
        return repositoryTransaccion.ListAll();
    }

}