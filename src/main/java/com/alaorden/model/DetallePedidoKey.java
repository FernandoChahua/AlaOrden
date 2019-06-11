package com.alaorden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Embeddable
public class DetallePedidoKey {

    @Column(name = "idPedido")
    private Integer idPedido;

    @Column(name = "idProducto")
    private Integer idProducto;


}
