package com.alaorden.model;

import java.util.List;
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

@Entity
@Table(name = "Franquicia")
public class Franquicia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFranquicia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "url")
    private String url;


    @Column(name = "Conexion")
    private String Conexion;

    @Column(name = "Logo")
    private String Logo;


    @OneToMany(mappedBy = "franquicia")
    private List<Sede> sedes;

}
