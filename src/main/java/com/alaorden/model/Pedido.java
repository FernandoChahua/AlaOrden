package com.alaorden.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "IdSede")
    private Sede sede;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "direccion")
    private String direccion;

    @OneToOne
    @JoinColumn(name = "transaccion")
    private Transaccion transaccion;

    @Column(name = "subTotal")
    private BigDecimal subTotal;

    @Column(name = "precioEnvio")
    private BigDecimal precioEnvio;

    @Column(name = "descuento")
    private BigDecimal descuento;

    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detallePedidos;
}
