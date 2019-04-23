/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.web.controller;

import com.myorg.core.entity.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.Pedido;
import com.myorg.core.entity.Sede;
import com.myorg.core.service.impl.PedidoServiceImpl;
import com.myorg.core.service.impl.SedeServiceImpl;

import org.primefaces.event.SelectEvent;
import org.myorg.util.Message;
@Named
@SessionScoped
public class PedidoController implements Serializable {

    private static final long serialVersionUID = 1L;

   @Inject
    private PedidoServiceImpl pedidoService;
    private SedeServiceImpl sedeService;
   
    private List<Pedido> pedidos;
    private Pedido pedidoSelect;
    private Pedido pedido;

    @PostConstruct
    public void init() {
        pedidos = new ArrayList<>();
        pedido = new Pedido();
        pedido.setSede(new Sede());
        pedido.setCliente(new Cliente());
        pedidoSelect = new Pedido();
        pedidoSelect.setSede(new Sede());
        pedidoSelect.setCliente(new Cliente());
        this.loadCategories();
    }
	public void loadCategories() {
		try {
			this.pedidos = pedidoService.findAll();
		} catch (Exception e) {
			Message.messageError("Error Category :" + e.getMessage());
		}
	}

	public void saveCategory() {
		try {
			if (pedido.getIdPedido() != null) {

				Message.messageInfo("Registro actualizado exitosamente");
				pedidoService.update(pedido);
			} else {
				pedidoService.insert(pedido);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadCategories();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Category :" + e.getStackTrace());
		}
	}

	public void editCategory() {
		try {
			if (this.pedidoSelect!=null) {
				this.pedido = pedidoSelect;
			} else {
				Message.messageInfo("Debe seleccionar una categoria");
			}
		} catch (Exception e) {
			Message.messageError("Error Categoria :" + e.getMessage());
		}

	}
	
	public void deleteCategory() {
		try {
			if (this.pedidoSelect != null) {
				pedidoService.delete(pedidoSelect);
				loadCategories();
				clearForm();

			} else {

			}
		} catch (Exception e) {

		}
	}

	public void selectCategory(SelectEvent e) {
		this.pedidoSelect = (Pedido) e.getObject();
	}
	
	public void clearForm() {
		this.pedido = new Pedido();
		this.pedidoSelect=null;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido getPedidoSelect() {
		return pedidoSelect;
	}

	public void setPedidoSelect(Pedido pedidoSelect) {
		this.pedidoSelect = pedidoSelect;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
