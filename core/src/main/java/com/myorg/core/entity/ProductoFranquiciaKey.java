package com.myorg.core.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ProductoFranquiciaKey implements Serializable {
    
    @Column(name = "idProducto")
    private Integer idProducto;
    
    @Column(name = "idFranquicia")
    private Integer idFranquicia;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(Integer idFranquicia) {
        this.idFranquicia = idFranquicia;
    }
    
    
}
