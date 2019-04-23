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
import org.myorg.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class ClienteController implements Serializable {

    @Inject
    private ClienteServiceImpl clienteService;

    private List<Cliente> clientes;
    private Cliente cliente;
    private Cliente clienteSel;

    @PostConstruct
    public void init() {
        clientes = new ArrayList<>();
        cliente = new Cliente();
        clienteSel = new Cliente();
        this.getAllClientes();
    }

    public void getAllClientes() {
        try {
            clientes = clienteService.findAll();
        } catch (Exception e) {
            Message.messageError("Error Cliente" + e.getMessage());
        }
    }

    public String newCliente() {
        return "newCliente?faces-redirect=true";
    }

    public void saveCliente() {
        try {
            if (cliente.getIdCliente() != 0) {
                clienteService.insert(cliente);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                clienteService.update(cliente);
                Message.messageInfo("Registro guardado exitosamente");
            }
        } catch (Exception e) {
            Message.messageError("Error Cliente" + e.getMessage());
        }
    }

    public void editCliente() {
        try {
            System.out.println("Customer Selec:" + clienteSel.getUsuario());
            if (this.clienteSel.getIdCliente()> 0) {
                this.cliente = clienteSel;
            } else {
                Message.messageInfo("Debe seleccionar un cliente");
                System.out.println("Hola:");
            }
        } catch (Exception e) {
            Message.messageError("Error Cliente :" + e.getMessage());
        }
    }

    	public void resetForm() {
		this.cliente = new Cliente();
		this.clienteSel = null;
	}

	public void selecCliente(SelectEvent e) {
		this.clienteSel = (Cliente) e.getObject();
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
