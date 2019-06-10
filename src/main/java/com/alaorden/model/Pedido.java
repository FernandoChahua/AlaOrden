package com.alaorden.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    private Usuario usuario;
    private Sede sede;
    private String estado;
    private String fecha;
    private String direccion;
    private Transaccion transaccion;
    private BigDecimal subTotal;
    private BigDecimal precioEnvio;
    private BigDecimal descuento;
    private List<DetallePedido> detallePedidos;
}
