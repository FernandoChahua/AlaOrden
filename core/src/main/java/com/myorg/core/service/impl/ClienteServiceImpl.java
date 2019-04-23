package com.myorg.core.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.impl.*;

@Named
public class ClienteServiceImpl implements Serializable{

    @Inject
    private ClienteRepositoryImpl clienteRepository;
    
    public void insert(Cliente obj) {
        clienteRepository.insert(obj);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
