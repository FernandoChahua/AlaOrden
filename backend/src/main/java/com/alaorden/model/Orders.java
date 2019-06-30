package com.alaorden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrders;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idLocation")
    private Location location;

    @Column(name = "state")
    private String state;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "idTransaction")
    private Transaction transaction;

    @Column(name = "subTotal")
    private BigDecimal subTotal;

    @Column(name = "priceDelivery")
    private BigDecimal priceDelivery;

    @Column(name = "discount")
    private BigDecimal discount;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetails;
}
