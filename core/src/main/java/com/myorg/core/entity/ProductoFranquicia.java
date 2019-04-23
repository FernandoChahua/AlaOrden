package com.myorg.core.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Producto_Franquicia")
public class ProductoFranquicia implements Serializable {
    
    @EmbeddedId
    private ProductoFranquiciaKey key;
    
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "idFranqucia")
    private Franquicia franquicia;
    
    @Column(name = "codReferencia")
    private String codReferencia;

    public ProductoFranquiciaKey getKey() {
        return key;
    }

    public void setKey(ProductoFranquiciaKey key) {
        this.key = key;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public String getCodReferencia() {
        return codReferencia;
    }

    public void setCodReferencia(String codReferencia) {
        this.codReferencia = codReferencia;
    }
    
    
}
