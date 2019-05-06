package com.myorg.web.controller;

import com.myorg.core.entity.DetallePedido;
import com.myorg.core.entity.Usuario;
import com.myorg.util.Message;
import com.myorg.util.SessionHelper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CarritoController implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<DetallePedido> carrito;
    private DetallePedido detalleSel;
    private DetallePedido detalle;
    private Usuario logeado;

    public Usuario getLogeado() {
        return logeado;
    }

    public void setLogeado(Usuario logeado) {
        this.logeado = logeado;
    }

    @PostConstruct
    public void init() {
        logeado = SessionHelper.getUsuario();
        logeado.setApodo("Si funciona :v");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", logeado);
        detalleSel = new DetallePedido();
        detalle = new DetallePedido();
            carrito = (List<DetallePedido>) SessionHelper.getCarrito();

    }

    public void editDetallePedido() {
        try {
            this.detalle = this.detalleSel;
        } catch (Exception e) {
            Message.messageError("Error detalle :" + e.getMessage());
        }
    }

    public void deleteDetallePedido() {
        try {
            carrito.remove(detalleSel);
        } catch (Exception e) {
            Message.messageError("Error detalle :" + e.getMessage());
        }
    }

    public List<DetallePedido> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<DetallePedido> carrito) {
        this.carrito = carrito;
    }

    public DetallePedido getDetalleSel() {
        return detalleSel;
    }

    public void setDetalleSel(DetallePedido detalleSel) {
        this.detalleSel = detalleSel;
    }

    public DetallePedido getDetalle() {
        return detalle;
    }

    public void setDetalle(DetallePedido detalle) {
        this.detalle = detalle;
    }

}
