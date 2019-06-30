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
public class OrderDetailKey implements Serializable {

    @Column(name = "idOrders")
    private Integer idOrders;

    @Column(name = "idProduct")
    private Integer idProduct;

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof OrderDetailKey))
            return false;
        OrderDetailKey key = (OrderDetailKey) obj;
        return Objects.equals(this.idOrders, key.idOrders) &&
                Objects.equals(this.idProduct, key.idProduct);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idOrders, idProduct);
    }
}
