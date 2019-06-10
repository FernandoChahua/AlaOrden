package com.alaorden.model;

import javax.persistence.*;

@Embeddable

public class DetallePedidoKey {

    @Column(name = "idPedido")
    private Integer idPedido;

    @Column(name = "idProducto")
    private Integer idProducto;


}
