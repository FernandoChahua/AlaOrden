package com.myorg.core.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Sede")
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSede;

    @ManyToOne
    @JoinColumn(name = "idFranquicia")
    private Franquicia franquicia;

    @Column(name = "direccion")
    private String direccion;

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
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
    
    @Override
    public String toString() {
        return franquicia.getNombre() + " - " + direccion;
    }
}