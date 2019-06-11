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
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @MapsId("idCategoria")
    @JoinColumn(name = "categoriaPadre")
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
}
