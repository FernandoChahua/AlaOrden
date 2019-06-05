package com.alaorden.model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    private int idCategoria;
    private String Nombre;
    private Categoria CategoriaPadre;
    private List<Producto> Productos;
}
