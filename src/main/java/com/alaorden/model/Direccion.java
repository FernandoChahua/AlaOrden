package com.alaorden.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idDireccion")
    private Integer idDireccion;

    @Column(name = "usuario")
    private Usuario usuario;

    @Column(name = "longitud")
    private BigDecimal longitud;

    @Column(name = "latitud")
    private BigDecimal latitud;

    @Column(name = "descripcion")
    private String descripcion;
}
