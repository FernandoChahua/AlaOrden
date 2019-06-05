package com.alaorden.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca {
    public int idMarca;
    public String nombre;
    public List<Producto> productos;
}
