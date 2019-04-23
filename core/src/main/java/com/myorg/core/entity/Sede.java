package com.myorg.core.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Sede")
public class Sede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSede;

    @ManyToOne
    @JoinColumn(name = "idFranquicia")
    private Franquicia franquicia;

    @Column(name = "direccion")
    private String direccion;

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}