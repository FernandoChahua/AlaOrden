package com.alaorden.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cupon {
    private int idCupon;
    private String codigo;
    private LocalDateTime fechaEmision;
    private LocalDateTime fechaExpiracion;
    private boolean vigente;
    private BigDecimal descuento;
    private Pedido usadoEnPedido;
}
