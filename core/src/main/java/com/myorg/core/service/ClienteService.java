package com.myorg.core.service;

import com.myorg.core.entity.Cliente;
import com.myorg.core.repository.ClienteRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ClienteService implements Serializable{

    @Inject
    private ClienteRepository clienteRepository;
    
    public void saveCliente(Cliente obj) {
        clienteRepository.save(obj);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
}
