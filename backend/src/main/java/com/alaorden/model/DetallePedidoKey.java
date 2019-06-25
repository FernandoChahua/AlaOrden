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
public class DetallePedidoKey  implements Serializable {

    @Column(name = "idPedido")
    private Integer idPedido;

    @Column(name = "idProducto")
    private Integer idProducto;

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (!(obj instanceof DetallePedidoKey))
            return false;
        DetallePedidoKey key = (DetallePedidoKey) obj;
        return Objects.equals(this.idPedido, key.idPedido) &&
                Objects.equals(this.idProducto, key.idProducto);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idPedido,idProducto);
    }
}
