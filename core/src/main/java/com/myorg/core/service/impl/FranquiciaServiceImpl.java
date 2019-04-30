package com.myorg.core.service.impl;

import com.myorg.core.entity.Franquicia;
import com.myorg.core.repository.IFranquiciaRepository;
import com.myorg.core.service.IFranquiciaService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class FranquiciaServiceImpl implements IFranquiciaService  {
    
    private static final long serialVersionUID = 1L;

    @Inject
    private IFranquiciaRepository franquiciaRepository;
    
    @Transactional
    @Override
    public boolean insert(Franquicia t) throws Exception {
        return franquiciaRepository.insert(t);
    }

    @Transactional
    @Override
    public boolean update(Franquicia t) throws Exception {
        return franquiciaRepository.update(t);
    }
    
    @Transactional
    @Override
    public boolean delete(Franquicia t) throws Exception {
        return franquiciaRepository.delete(t);
    }

    @Override
    public Franquicia findById(Franquicia t) throws Exception {
        return franquiciaRepository.findById(t);
    }

    @Override
    public List<Franquicia> findAll() throws Exception {
        return franquiciaRepository.findAll();
    }
    
}