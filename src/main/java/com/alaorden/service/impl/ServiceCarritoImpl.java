package com.alaorden.service.impl;

import com.alaorden.model.Carrito;
import com.alaorden.repository.RepositoryCarrito;
import com.alaorden.service.ServiceCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCarritoImpl implements ServiceCarrito {
    RepositoryCarrito repositoryCarrito;

    @Autowired
    public ServiceCarritoImpl(RepositoryCarrito repositoryCarrito){
        this.repositoryCarrito = repositoryCarrito;
    }
    @Override
    public void Delete(Carrito entity){
        repositoryCarrito.Delete(entity);
    }
    @Override
    public void Save(Carrito entity){
        repositoryCarrito.Save(entity);
    }
    @Override
    public void Update(Carrito entity){
        repositoryCarrito.Update(entity);
    }
    @Override
    public Carrito FindById(Carrito entity){
        return repositoryCarrito.FindById(entity);
    }
    @Override
    public List<Carrito> ListAll(){
        return repositoryCarrito.ListAll();
    }

}