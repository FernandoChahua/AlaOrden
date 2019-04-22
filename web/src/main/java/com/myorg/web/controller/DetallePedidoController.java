package com.myorg.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.DetallePedido;
import com.myorg.core.service.DetallePedidoService;

@Named
@SessionScoped
public class DetallePedidoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DetallePedidoService detallePedidoService;

    private List<DetallePedido> detallesPedido;
    private DetallePedido detallePedido;

    @PostConstruct
    public void init() {
        detallesPedido = new ArrayList<>();
        detallePedido = new DetallePedido();
        this.getAllDetallesPedido();
    }

    public void getAllDetallesPedido() {
        detallesPedido = detallePedidoService.getAllDetallesPedido();
    }

    public String newDetallePedido() {
        return "newDetallePedido?faces-redirect=true";
    }

    public String saveDetallePedido() {
        String rpta = "";
        try {
            detallePedidoService.saveDetallePedido(detallePedido);
            this.getAllDetallesPedido();
            rpta = "visorDetallePedido?faces-redirect=true";
        } catch (Exception e) {
            // TODO: handle exception
        }

        return rpta;
    }

    public List<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

}
