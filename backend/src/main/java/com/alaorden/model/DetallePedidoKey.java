package com.alaorden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Embeddable
public class DetallePedidoKey  implements Serializable {

    @Column(name = "idPedido")
    private Integer idPedido;

    @Column(name = "idProducto")
    private Integer idProducto;


}
