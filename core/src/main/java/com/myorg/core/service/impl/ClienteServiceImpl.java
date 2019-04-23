package com.myorg.core.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.impl.*;
import com.myorg.core.service.IClienteService;
import javax.transaction.Transactional;

@Named
public class ClienteServiceImpl implements IClienteService ,Serializable{

    @Inject
    private ClienteRepositoryImpl clienteRepository;

    @Override
    @Transactional
    public boolean insert(Cliente c) throws Exception {
        return clienteRepository.insert(c);
    }

    @Override
    @Transactional
    public boolean update(Cliente c) throws Exception {
        return clienteRepository.update(c);
    }

    @Override
    @Transactional
    public boolean delete(Cliente c) throws Exception {
        return clienteRepository.delete(c);
    }

    @Override
    public Cliente findById(Cliente c) throws Exception {
        return clienteRepository.findById(c);
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        return clienteRepository.findAll();
    }
    
    
}
