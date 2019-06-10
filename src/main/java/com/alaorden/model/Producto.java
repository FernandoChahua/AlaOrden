package com.alaorden.model;

import java.math.BigDecimal;
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
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private Categoria categoria;
    private Marca marca;
    private String nombre;
    private String presentacion;
    private int cantidad;
    private BigDecimal magnitud;
    private String unidad;
    private String descripcion;
    private String imagen;
    private List<ProductoFranquicia> productosFranquicia;
}
