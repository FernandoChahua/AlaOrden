package com.myorg.core.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.impl.*;
import com.myorg.core.service.IProductoService;
import javax.transaction.Transactional;

@Named
public class ProductoServiceImpl implements Serializable, IProductoService{

    private static final long serialVersionUID = 1L;
	
    @Inject
    private ProductoRepositoryImpl productoRepository;
    
    @Transactional
    @Override
    public boolean insert(Producto p) throws Exception{
        return productoRepository.insert(p);
    }

    @Override
    public List<Producto> findAll() throws Exception{
        return productoRepository.findAll();
    }

    @Transactional
    @Override
    public boolean update(Producto p) throws Exception {
        return productoRepository.update(p);
    }

    @Transactional
    @Override
    public boolean delete(Producto p) throws Exception {
        return productoRepository.delete(p);
    }

    @Override
    public Producto findById(Producto p) throws Exception {
        try{
            return productoRepository.findById(p);
        }catch(Exception ex){
            throw ex;
        }
    }
	

}
