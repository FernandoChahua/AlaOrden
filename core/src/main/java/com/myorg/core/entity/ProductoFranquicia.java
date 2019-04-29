package com.myorg.core.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Producto_Franquicia")
public class ProductoFranquicia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private ProductoFranquiciaKey pk;
    
    @ManyToOne
    @MapsId("idProducto")
    private Producto producto;
    
    @ManyToOne
    @MapsId("idFranqucia")
    private Franquicia franquicia;
    
    @Column(name = "codReferencia")
    private String codReferencia;

    public ProductoFranquiciaKey getPk() {
        return pk;
    }

    public void setPk(ProductoFranquiciaKey pk) {
        this.pk = pk;
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
