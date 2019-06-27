package com.alaorden.model;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent",referencedColumnName = "idCategory")
    private Category parent;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Product> products;
    
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    public List<Category> subCategories;
}
