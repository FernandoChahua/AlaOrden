package com.alaorden.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Producto_Franquicia")
public class ProductoFranquicia {

    @EmbeddedId
    private ProductoFranquiciaKey pk;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @MapsId("idFranquicia")
    @JoinColumn(name = "idFranquicia")
    private Franquicia franquicia;

    @Column(name = "codReferencia")
    private String codReferencia;
}
