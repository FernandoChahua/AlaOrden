package com.alaorden.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCupon;
    private String codigo;
    private LocalDateTime fechaEmision;
    private LocalDateTime fechaExpiracion;
    private boolean vigente;
    private BigDecimal descuento;
    private Pedido usadoEnPedido;
}
