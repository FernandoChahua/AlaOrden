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
public class Franquicia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFranquicia;
    private String nombre;
    private String url;
    private String Conexion;
    private String Logo;
    private List<Sede> sedes;
    private List<ProductoFranquicia> productoFranquicia;
}
