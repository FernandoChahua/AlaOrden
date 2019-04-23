package com.myorg.core.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.impl.*;
import com.myorg.core.service.ICategoriaService;
import javax.transaction.Transactional;

@Named
public class CategoriaServiceImpl implements Serializable, ICategoriaService{

    private static final long serialVersionUID = 1L;
	
    @Inject
    private CategoriaRepositoryImpl categoriaRepository;
    
    @Transactional
    @Override
    public boolean insert(Categoria t) throws Exception {
        return categoriaRepository.insert(t);
    }

    @Override
    public boolean update(Categoria t) throws Exception {
        return categoriaRepository.update(t); 
    }

    @Override
    public boolean delete(Categoria t) throws Exception {
        return categoriaRepository.delete(t);
    }

    @Override
    public Categoria findById(Categoria t) throws Exception {
        try{
            return categoriaRepository.findById(t);
        }catch(Exception ex){
            throw ex;
        }
    }

    @Override
    public List<Categoria> findAll() throws Exception {
        return categoriaRepository.findAll();
    }
    
}
