package com.alaorden.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {
    private Usuario usuario;
    private Producto producto;
    private int cantidad;
}
