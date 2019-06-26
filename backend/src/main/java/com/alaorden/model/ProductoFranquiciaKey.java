package com.alaorden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Embeddable
public class ProductoFranquiciaKey  implements Serializable {

    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "idFranquicia")
    private Integer idFranquicia;

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof ProductoFranquiciaKey))
            return false;
        ProductoFranquiciaKey key = (ProductoFranquiciaKey) obj;
        return Objects.equals(this.idProducto, key.idProducto) &&
                Objects.equals(this.idFranquicia, key.idFranquicia);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idProducto,idFranquicia);
    }
}
