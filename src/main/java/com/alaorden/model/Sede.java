package com.alaorden.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sede {
    private int idSede;
    private String direccion;
    private Franquicia franquicia;
    private BigDecimal logngitud;
    private BigDecimal latitud;
}
