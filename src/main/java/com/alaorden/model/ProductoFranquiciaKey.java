package com.alaorden.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class ProductoFranquiciaKey {

    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "idFranquicia")
    private Integer idFranquicia;
}
