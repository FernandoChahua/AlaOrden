package com.alaorden.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Embeddable
public class CarritoItemKey {

    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "idProducto")
    private Integer idProducto;


}
