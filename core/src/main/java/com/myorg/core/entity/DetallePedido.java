package com.myorg.core.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "DetallePedido")
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DetallePedido key;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "cantidad")
    private Integer cantidad;

    public DetallePedido getKey() {
        return key;
    }

    public void setKey(DetallePedido key) {
        this.key = key;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


}
