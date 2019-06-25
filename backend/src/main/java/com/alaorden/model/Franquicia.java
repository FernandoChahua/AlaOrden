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
@Table(name = "Franquicia")
public class Franquicia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFranquicia;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "webUrl")
    private String webUrl;

    @Column(name = "apiUrl")
    private String apiUrl;

    @Column(name = "Logo")
    private String Logo;

    @OneToMany(mappedBy = "franquicia")
    private List<Sede> sedes;

}
