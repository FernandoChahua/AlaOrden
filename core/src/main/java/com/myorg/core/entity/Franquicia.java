package com.myorg.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Franquicia")
public class Franquicia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFranquicia;

    @Column(name = "nombre" , unique=true)
    private String nombre;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "franquicia")
    private List<Sede> sedes;
    
    @OneToMany(mappedBy = "franquicia")
    private List<ProductoFranquicia> productoFranquicias;
    
    public Integer getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(Integer idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }

    public List<ProductoFranquicia> getProductofranquicias() {
        return productoFranquicias;
    }

    public void setProductofranquicias(List<ProductoFranquicia> productofranquicias) {
        this.productoFranquicias = productofranquicias;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
