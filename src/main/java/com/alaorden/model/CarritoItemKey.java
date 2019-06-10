package com.alaorden.model;

import javax.persistence.*;

@Embeddable



public class CarritoItemKey {

    @Column(name = "idPedido")
    private Integer idPedido;

    @Column(name = "idProducto")
    private Integer idProducto;


}
