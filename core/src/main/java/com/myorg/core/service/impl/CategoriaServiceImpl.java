package com.myorg.core.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.ICategoriaRepository;
import com.myorg.core.service.ICategoriaService;
import javax.transaction.Transactional;

@Named
public class CategoriaServiceImpl implements ICategoriaService{

    private static final long serialVersionUID = 1L;
	
    @Inject
    private ICategoriaRepository categoriaRepository;
    
    @Transactional
    @Override
    public boolean insert(Categoria c) throws Exception {
        return categoriaRepository.insert(c);
    }

    @Transactional
    @Override
    public boolean update(Categoria c) throws Exception {
        return categoriaRepository.update(c); 
    }

    @Transactional
    @Override
    public boolean delete(Categoria c) throws Exception {
        return categoriaRepository.delete(c);
    }

    @Override
    public Categoria findById(Categoria c) throws Exception {
        return categoriaRepository.findById(c);
    }

    @Override
    public List<Categoria> findAll() throws Exception {
        return categoriaRepository.findAll();
    }
    
}
