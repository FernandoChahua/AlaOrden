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
public class CarritoItemKey implements Serializable {

    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "idProducto")
    private Integer idProducto;


}
