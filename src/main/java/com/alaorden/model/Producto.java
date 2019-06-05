package com.alaorden.model;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
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
