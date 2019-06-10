package com.alaorden.model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int idCategoria;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "CategoriaPadre")
    private Categoria CategoriaPadre;

    @OneToMany(mappedBy = "Categoria")
    private List<Producto> Productos;
}
