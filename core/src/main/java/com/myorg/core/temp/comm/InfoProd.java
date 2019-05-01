package com.myorg.core.temp.comm;

import java.math.BigDecimal;

//CLASE para guarda precio y stock;
public class InfoProd {
    public BigDecimal precio;
    public int stock;
    
    public InfoProd(BigDecimal precio, int stock){
        this.precio = precio;
        this.stock = stock;
    }
}
