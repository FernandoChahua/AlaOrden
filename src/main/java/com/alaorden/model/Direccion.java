package com.alaorden.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private int idDireccion;
    private Usuario usuario;
    private BigDecimal longitud;
    private BigDecimal latitud;
    private String descripcion;
}
