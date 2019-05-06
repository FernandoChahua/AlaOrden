/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.web.controller;

import com.myorg.core.entity.DetallePedido;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.myorg.core.entity.Pedido;
import com.myorg.util.Message;
import com.myorg.util.SessionHelper;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Named
@ViewScoped
public class ReciboController implements Serializable {

    private Pedido pedido;
    private DetallePedido detallePedidoSelect;

    @PostConstruct
    public void init() {
        pedido = SessionHelper.getPedido();
        detallePedidoSelect = new DetallePedido();
    }
    

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public DetallePedido getDetallePedidoSelect() {
        return detallePedidoSelect;
    }

    public void setDetallePedidoSelect(DetallePedido detallePedidoSelect) {
        this.detallePedidoSelect = detallePedidoSelect;
    }

}
