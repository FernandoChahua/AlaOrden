package com.myorg.core.service.impl;

import com.myorg.core.entity.Rol;
import com.myorg.core.repository.IRolRepository;
import com.myorg.core.service.IRolService;
import java.util.List;
import javax.inject.*;
import javax.transaction.Transactional;

@Named
public class RolServiceImpl implements IRolService {

    private static final long serialVersionUID = 1L;

    @Inject
    private IRolRepository rolRepository;

    @Transactional
    @Override
    public boolean insert(Rol r) throws Exception {
        return rolRepository.insert(r);
    }

    @Transactional
    @Override
    public boolean update(Rol r) throws Exception {
        return rolRepository.update(r);
    }

    @Transactional
    @Override
    public boolean delete(Rol r) throws Exception {
        return rolRepository.delete(r);
    }

    @Override
    public Rol findById(Rol r) throws Exception {
        return rolRepository.findById(r);
    }

    @Override
    public List<Rol> findAll() throws Exception {
        return rolRepository.findAll();
    }

}
