package com.alaorden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Embeddable
public class ProductoFranquiciaKey  implements Serializable {

    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "idFranquicia")
    private Integer idFranquicia;
}
