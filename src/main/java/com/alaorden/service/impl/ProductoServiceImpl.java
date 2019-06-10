package com.alaorden.service.impl;

import com.alaorden.model.Producto;
import com.alaorden.repository.ProductoRepository;
import com.alaorden.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
    @Override
    public void Delete(Producto entity){
        productoRepository.Delete(entity);
    }
    @Override
    public void Save(Producto entity){
        productoRepository.Save(entity);
    }
    @Override
    public void Update(Producto entity){
        productoRepository.Update(entity);
    }
    @Override
    public Producto FindById(Producto entity){
        return productoRepository.FindById(entity);
    }
    @Override
    public List<Producto> ListAll(){
        return productoRepository.ListAll();
    }

}