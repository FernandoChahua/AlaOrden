package com.alaorden.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DetallePedido")
public class DetallePedido {


    @EmbeddedId
    private DetallePedidoKey pk;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "precio")
    private BigDecimal precio;


    @Column(name = "cantidad")
    private int cantidad;
}
