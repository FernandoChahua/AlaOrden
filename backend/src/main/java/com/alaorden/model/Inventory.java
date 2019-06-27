package com.alaorden.model;
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
@Table(name = "Inventory")
public class Inventory {

    @EmbeddedId
    private InventoryKey pk;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "idProduct")
    private Product product;

    @ManyToOne
    @MapsId("idFranchise")
    @JoinColumn(name = "idFranchise")
    private Franchise franchise;

    @Column(name = "refCode")
    private String refCode;
}
