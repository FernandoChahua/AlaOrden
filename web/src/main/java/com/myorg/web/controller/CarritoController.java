
package com.myorg.web.controller.crud;

import com.myorg.core.entity.DetallePedido;
import com.myorg.util.Message;
import com.myorg.util.SessionHelper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CarritoController implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private List<DetallePedido>carrito;
    private DetallePedido detalleSel;
    private DetallePedido detalle;

    
    
    
    
    @PostConstruct
    public void init() {
        detalleSel=new DetallePedido();
        detalle=new DetallePedido();
        carrito = SessionHelper.getCarrito();
    }
    
    public void editDetallePedido() {
        try {
            
                this.detalle = this.detalleSel;
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
