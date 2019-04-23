package com.myorg.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.myorg.core.entity.Cliente;
import com.myorg.core.service.impl.ClienteServiceImpl;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class ClienteController implements Serializable{
    
    @Inject
    private ClienteServiceImpl clienteService;

    private List<Cliente> clientes;
    private Cliente cliente;


    @PostConstruct
    public void init() {
        clientes = new ArrayList<>();
        cliente = new Cliente();
        this.getAllClientes();
    }

    public void getAllClientes() {
        clientes = clienteService.findAll();
    }

    public String newCliente() {
        return "newCliente?faces-redirect=true";
    }

    public String saveCliente() {
        String rpta = "";
        try {
            clienteService.insert(cliente);
            this.getAllClientes();
            rpta = "visorCliente?faces-redirect=true";
        } catch (Exception e) {
            // TODO: handle exception
        }

        return rpta;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
