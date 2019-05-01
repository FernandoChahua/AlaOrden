/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.core.temp.ext;

import java.math.BigDecimal;

/**
 *
 * @author Alexia
 */
public class ProductoExtA {

    int id;
    String nombre;
    int id_proveedor;
    int id_categoria;
    String unidad_por_cantidad;
    BigDecimal precio_unitario;
    short unidades_en_stock;
    boolean descontinuado;
    
 public Integer getIdProductoExtA() {
        return id;
    }
    
}
