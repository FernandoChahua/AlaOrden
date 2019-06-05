package com.alaorden.service.impl;

import com.alaorden.model.ProductoFranquicia;
import com.alaorden.repository.RepositoryProductoFranquicia;
import com.alaorden.service.ServiceProductoFranquicia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductoFranquiciaImpl implements ServiceProductoFranquicia {
    RepositoryProductoFranquicia repositoryProductoFranquicia;

    @Autowired
    public ServiceProductoFranquiciaImpl(RepositoryProductoFranquicia repositoryProductoFranquicia){
        this.repositoryProductoFranquicia = repositoryProductoFranquicia;
    }
    @Override
    public void Delete(ProductoFranquicia entity){
        repositoryProductoFranquicia.Delete(entity);
    }
    @Override
    public void Save(ProductoFranquicia entity){
        repositoryProductoFranquicia.Save(entity);
    }
    @Override
    public void Update(ProductoFranquicia entity){
        repositoryProductoFranquicia.Update(entity);
    }
    @Override
    public ProductoFranquicia FindById(ProductoFranquicia entity){
        return repositoryProductoFranquicia.FindById(entity);
    }
    @Override
    public List<ProductoFranquicia> ListAll(){
        return repositoryProductoFranquicia.ListAll();
    }

}