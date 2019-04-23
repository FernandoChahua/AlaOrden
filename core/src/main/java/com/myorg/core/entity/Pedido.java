package com.myorg.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idSede")
    private Sede sede;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nroTransaccion")
    private int nroTransaccion;

    @Column(name = "subtotal", precision = 7, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "precioEnvio", precision = 7, scale = 2)
    private BigDecimal precioEnvio;

    @Column(name = "descuento", precision = 7, scale = 2)
    private BigDecimal descuento;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetallePedido> detalles;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
