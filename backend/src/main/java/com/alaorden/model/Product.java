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
    private String name;

    @Column(name = "packaging")
    private String packaging;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "measure")
    private BigDecimal measure;

    @Column(name = "unit")
    private String unit;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "product")
    private List<Inventory> inventory;
}
