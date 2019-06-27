package com.alaorden.model;

import java.util.List;
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
@Table(name = "Franchise")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFranchise;

    @Column(name = "name")
    private String name;

    @Column(name = "webUrl")
    private String webUrl;

    @Column(name = "apiUrl")
    private String apiUrl;

    @Column(name = "logo")
    private String logo;

    @OneToMany(mappedBy = "franchise")
    private List<Location> locations;

}
