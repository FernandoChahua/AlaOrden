package com.myorg.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany
    @JoinTable(name = "Rol_Usuario",
            joinColumns = {@JoinColumn(name = "idRol")},
            inverseJoinColumns = {@JoinColumn(name = "idUsuario")})
    private List<Usuario> usuarios;
}
