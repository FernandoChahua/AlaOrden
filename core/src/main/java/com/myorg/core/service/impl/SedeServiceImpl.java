package com.myorg.core.service.impl;

import com.myorg.core.entity.Sede;
import com.myorg.core.repository.ISedeRepository;
import com.myorg.core.service.ISedeService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
public class SedeServiceImpl implements ISedeService {

    private static final long serialVersionUID = 1L;

    @Inject
    private ISedeRepository sedeRepository;
    
    @Transactional
    @Override
    public boolean insert(Sede t) throws Exception {
        return sedeRepository.insert(t);
    }

    @Transactional
    @Override
    public boolean update(Sede t) throws Exception {
        return sedeRepository.update(t);
    }
    
    @Transactional
    @Override
    public boolean delete(Sede t) throws Exception {
        return sedeRepository.delete(t);
    }
    
    @Override
    public Sede findById(Sede t) throws Exception {
        return sedeRepository.findById(t);
    }
    
    @Override
    public List findAll() throws Exception {
        return sedeRepository.findAll();
    }
    
}
