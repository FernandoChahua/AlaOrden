package com.myorg.core.service.impl;

import com.myorg.core.entity.ProductoFranquicia;
import com.myorg.core.repository.IProductoFranquiciaRepository;
import com.myorg.core.service.IProductoFranquiciaService;
import java.util.List;
import javax.transaction.Transactional;

public class ProductoFranquiciaServiceImpl implements IProductoFranquiciaService {

    IProductoFranquiciaRepository productoFranquiciaRepository;
    
    @Transactional
    @Override
    public boolean insert(ProductoFranquicia pf) throws Exception {
        return productoFranquiciaRepository.insert(pf);
    }

    @Transactional
    @Override
    public boolean update(ProductoFranquicia pf) throws Exception {
        return productoFranquiciaRepository.update(pf);
    }

    @Transactional
    @Override
    public boolean delete(ProductoFranquicia pf) throws Exception {
        return productoFranquiciaRepository.delete(pf);
    }

    @Override
    public ProductoFranquicia findById(ProductoFranquicia pf) throws Exception {
        return productoFranquiciaRepository.findById(pf);
    }

    @Override
    public List<ProductoFranquicia> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
