package com.alaorden.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoFranquicia {
    private Producto producto;
    private Franquicia franquicia;
    private String codReferencia;
}
