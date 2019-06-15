package com.alaorden.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "apodo")
    private String apodo;

    @Column(name = "hashContrasena")
    private String hashContrasena;

    @Column(name = "sal")
    private String sal;

    @Column(name = "email")
    private String email;

    @Column(name = "emailValidado")
    private boolean emailValidado;

    @OneToMany(mappedBy = "usuario")
    private List<Direccion> direcciones;

    @OneToMany(mappedBy = "usuario")
    private List<CarritoItem> carrito;

}
