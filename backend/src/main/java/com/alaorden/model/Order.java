package com.alaorden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "IdSede")
    private Location location;

    @Column(name = "state")
    private String state;

    @Column(name = "date")
    private String date;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "transaction")
    private Transaction transaction;

    @Column(name = "subTotal")
    private BigDecimal subTotal;

    @Column(name = "priceDelivery")
    private BigDecimal priceDelivery;

    @Column(name = "discount")
    private BigDecimal discount;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}
