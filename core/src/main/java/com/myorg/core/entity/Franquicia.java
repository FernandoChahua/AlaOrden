package com.myorg.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Franquicia")
public class Franquicia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFranquicia;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "franquicia",cascade = CascadeType.ALL)
    private List<Sede> sedes;
    
    @OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL)
    private List<ProductoFranquicia> productoFranquicias;

    public int getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(int idFranquicia) {
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

   
}