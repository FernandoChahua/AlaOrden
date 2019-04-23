package com.myorg.core.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class DetallePedidoKey implements Serializable {
    
    @Column(name = "idPedido")
    private Integer idPedido;
    
    @Column(name = "idProducto")
    private Integer idProducto;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
