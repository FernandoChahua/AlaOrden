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
import com.myorg.core.service.PedidoService;

@Named
@SessionScoped
public class PedidoController implements Serializable {

    private static final long serialVersionUID = 1L;

   @Inject
    private PedidoService pedidoService;

    private List<Pedido> pedidos;
    private Pedido pedido;

    @PostConstruct
    public void init() {
        pedidos = new ArrayList<>();
        pedido = new Pedido();
        pedido.setSede(new Sede());
        pedido.setCliente(new Cliente());
        this.getAllPedidos();
    }

    public void getAllPedidos() {
        pedidos = pedidoService.getAllPedidos();
    }

    public String newPedido() {
        return "newPedido?faces-redirect=true";
    }

    public String savePedido() {
        String rpta = "";
        try {
            pedidoService.savePedido(pedido);
            this.getAllPedidos();
            rpta = "visorPedido?faces-redirect=true";
        } catch (Exception e) {
            // TODO: handle exception
        }

        return rpta;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
