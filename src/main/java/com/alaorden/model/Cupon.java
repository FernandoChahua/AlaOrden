package com.alaorden.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private int idCupon;

    @Column(name = "codigo")
=======
    private Integer idCupon;
>>>>>>> f36e61b50c5ba9d6e098e775ea26c52c7afc8481
    private String codigo;

    @Column(name = "fechaEmision")
    private LocalDateTime fechaEmision;

    @Column(name = "fechaExpiracion")
    private LocalDateTime fechaExpiracion;

    @Column(name = "vigente")
    private boolean vigente;

    @Column(name = "descuento")
    private BigDecimal descuento;

    @Column(name = "usadoEnPedido")
    private Pedido usadoEnPedido;
}
