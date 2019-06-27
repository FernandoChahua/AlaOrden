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
public class InventoryKey implements Serializable {

    @Column(name = "idProduct")
    private Integer idProduct;

    @Column(name = "idFranchise")
    private Integer idFranchise;

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof InventoryKey))
            return false;
        InventoryKey key = (InventoryKey) obj;
        return Objects.equals(this.idProduct, key.idProduct) &&
                Objects.equals(this.idFranchise, key.idFranchise);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idProduct, idFranchise);
    }
}
