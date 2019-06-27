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
public class CartItemKey implements Serializable {

    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "idProduct")
    private Integer idProduct;

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof CartItemKey))
            return false;
        CartItemKey key = (CartItemKey) obj;
        return Objects.equals(this.idUser, key.idUser) &&
                Objects.equals(this.idProduct, key.idUser);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idUser, idProduct);
    }
}
