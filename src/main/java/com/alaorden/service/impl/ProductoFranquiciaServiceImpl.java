package com.alaorden.service.impl;

import com.alaorden.model.ProductoFranquicia;
import com.alaorden.repository.ProductoFranquiciaRepository;
import com.alaorden.service.ProductoFranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoFranquiciaServiceImpl implements ProductoFranquiciaService {
    ProductoFranquiciaRepository productoFranquiciaRepository;

    @Autowired
    public ProductoFranquiciaServiceImpl(ProductoFranquiciaRepository productoFranquiciaRepository){
        this.productoFranquiciaRepository = productoFranquiciaRepository;
    }
    @Override
    public void Delete(ProductoFranquicia entity){
        productoFranquiciaRepository.Delete(entity);
    }
    @Override
    public void Save(ProductoFranquicia entity){
        productoFranquiciaRepository.Save(entity);
    }
    @Override
    public void Update(ProductoFranquicia entity){
        productoFranquiciaRepository.Update(entity);
    }
    @Override
    public ProductoFranquicia FindById(ProductoFranquicia entity){
        return productoFranquiciaRepository.FindById(entity);
    }
    @Override
    public List<ProductoFranquicia> ListAll(){
        return productoFranquiciaRepository.ListAll();
    }

}