package com.alaorden.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Sede")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSede;

    @Column(name = "direccion")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idFranquicia")
    private Franquicia franquicia;

    @Column(name = "longitud")
    private BigDecimal logngitud;

    @Column(name = "latitud")
    private BigDecimal latitud;
}
