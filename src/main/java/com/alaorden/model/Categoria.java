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
    private String Nombre;

    @Column(name = "categoriaPadre")
    private Categoria CategoriaPadre;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> Productos;
}
