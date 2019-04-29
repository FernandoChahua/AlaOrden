package com.myorg.core.service.impl;

import com.myorg.core.entity.Marca;
import com.myorg.core.repository.IMarcaRepository;
import com.myorg.core.service.IMarcaService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class MarcaServiceImpl implements IMarcaService {

    @Inject
    IMarcaRepository marcaRepository;
    
    @Transactional
    @Override
    public boolean insert(Marca m) throws Exception {
        return marcaRepository.insert(m);
    }

    @Transactional
    @Override
    public boolean update(Marca m) throws Exception {
        return marcaRepository.update(m);
    }

    @Transactional
    @Override
    public boolean delete(Marca m) throws Exception {
        return marcaRepository.delete(m);
    }

    @Override
    public Marca findById(Marca m) throws Exception {
        return marcaRepository.findById(m);
    }

    @Override
    public List<Marca> findAll() throws Exception {
        return marcaRepository.findAll();
    }

}
