package com.alaorden.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idCoupon;

    @Column(name = "code")
    private String code;

    @Column(name = "issueDate")
    private LocalDateTime issueDate;

    @Column(name = "expirationDate")
    private LocalDateTime expirationDate;

    @Column(name = "active")
    private boolean active;

    @Column(name = "discount")
    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "idOrder")
    private Order order;
}
