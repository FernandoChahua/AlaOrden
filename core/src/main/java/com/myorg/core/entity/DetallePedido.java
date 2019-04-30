package com.myorg.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "DetallePedido")
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DetallePedidoKey pk;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "cantidad")
    private Integer cantidad;

    public DetallePedidoKey getPk() {
        return pk;
    }

    public void setPk(DetallePedidoKey pk) {
        this.pk = pk;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


}
