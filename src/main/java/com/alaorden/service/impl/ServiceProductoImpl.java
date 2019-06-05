package com.alaorden.service.impl;

import com.alaorden.model.Producto;
import com.alaorden.repository.RepositoryProducto;
import com.alaorden.service.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductoImpl implements ServiceProducto {
    RepositoryProducto repositoryProducto;

    @Autowired
    public ServiceProductoImpl(RepositoryProducto repositoryProducto){
        this.repositoryProducto = repositoryProducto;
    }
    @Override
    public void Delete(Producto entity){
        repositoryProducto.Delete(entity);
    }
    @Override
    public void Save(Producto entity){
        repositoryProducto.Save(entity);
    }
    @Override
    public void Update(Producto entity){
        repositoryProducto.Update(entity);
    }
    @Override
    public Producto FindById(Producto entity){
        return repositoryProducto.FindById(entity);
    }
    @Override
    public List<Producto> ListAll(){
        return repositoryProducto.ListAll();
    }

}