package com.alaorden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Embeddable
public class ProductoFranquiciaKey {

    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "idFranquicia")
    private Integer idFranquicia;
}
