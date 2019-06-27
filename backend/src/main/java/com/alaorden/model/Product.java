package com.alaorden.model;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "idBrand")
    private Brand brand;

    @Column(name = "name")
    private String nombre;

    @Column(name = "presentation")
    private String presentation;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "magnitude")
    private BigDecimal magnitude;

    @Column(name = "unity")
    private String unity;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "product")
    private List<Inventory> inventory;
}
