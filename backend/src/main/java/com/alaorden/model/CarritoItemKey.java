package com.alaorden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Embeddable
public class CarritoItemKey implements Serializable {

    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "idProducto")
    private Integer idProducto;

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof CarritoItemKey))
            return false;
        CarritoItemKey key = (CarritoItemKey) obj;
        return Objects.equals(this.idUsuario, key.idUsuario) &&
                Objects.equals(this.idProducto, key.idProducto);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idUsuario,idProducto);
    }
}
