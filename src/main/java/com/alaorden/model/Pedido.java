package com.alaorden.model;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {
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
