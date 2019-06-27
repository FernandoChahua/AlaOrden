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
@Table(name = "OrderDetail")
public class OrderDetail {


    @EmbeddedId
    private OrderDetailKey pk;

    @ManyToOne
    @MapsId("idOrder")
    @JoinColumn(name = "idOrder")
    private Order order;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "idProduct")
    private Product product;

    @Column(name = "price")
    private BigDecimal price;


    @Column(name = "quantity")
    private int quantity;
}
