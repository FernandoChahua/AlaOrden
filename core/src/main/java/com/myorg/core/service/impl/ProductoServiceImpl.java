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
    public boolean insert(Producto p) throws Exception {
        boolean rpta = false;
        try{
            productoRepository.insert(p);
            rpta = true;
        }catch(Exception ex){
            throw ex;
        }
        return rpta;
    }

    @Override
    public List<Producto> findAll()throws Exception {
        try{
            return productoRepository.findAll();
        }catch(Exception ex){
            throw ex;
        }
    }

    @Transactional
    @Override
    public boolean update(Producto p) throws Exception {
        boolean rpta = false;
        try{
            productoRepository.update(p);
            rpta = true;
        }catch(Exception ex){
            throw ex;
        }
        return rpta;
    }

    @Transactional
    @Override
    public boolean delete(Producto p) throws Exception {
        boolean rpta = false;
        try{
            productoRepository.delete(p);
            rpta = true;
        }catch(Exception ex){
            throw ex;
        }
        return rpta;
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
