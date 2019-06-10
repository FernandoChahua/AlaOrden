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
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "presentacion")
    private String presentacion;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "magnitud")
    private BigDecimal magnitud;

    @Column(name = "unidad")
    private String unidad;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @OneToMany(mappedBy = "producto")
    private List<ProductoFranquicia> productosFranquicia;
}
