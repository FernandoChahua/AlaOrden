package com.myorg.core.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class ProductoFranquiciaKey implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductoFranquiciaKey that = (ProductoFranquiciaKey) o;
        return Objects.equals(idProducto, that.idProducto)
                && Objects.equals(idFranquicia, that.idFranquicia);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(idProducto,idFranquicia);
    }
}
