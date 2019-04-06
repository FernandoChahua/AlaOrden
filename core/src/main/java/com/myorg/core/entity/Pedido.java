package com.myorg.core.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Pedido {
    
    private int idPedido;
    
    private Cliente cliente;
    
    private String estado;
    
    private String direccion;
    
    private Sede sede;
    
    private Date fecha;
    
    private int nroTransaccion;

    private BigDecimal subtotal;

    private BigDecimal precioEnvio;

    private BigDecimal descuento;
    
    private List<DetallePedido> detalles;


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNroTransaccion() {
        return nroTransaccion;
    }

    public void setNroTransaccion(int nroTransaccion) {
        this.nroTransaccion = nroTransaccion;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(BigDecimal precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
}