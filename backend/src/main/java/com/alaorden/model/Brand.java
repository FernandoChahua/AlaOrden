package com.alaorden.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idBrand;

    @Column(name = "name")
    public String name;

    @JsonIgnore
    @OneToMany(mappedBy = "brand",fetch = FetchType.LAZY)
    public List<Product> products;
}
