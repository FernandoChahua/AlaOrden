package com.myorg.core.service.comm.ext;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Product implements Serializable{
    @Id
    private int id;
    @Column
    private String nombre;
    @Column
    private int id_proveedor;
    @Column
    private int id_categoria;
    @Column
    private String unidad_por_cantidad;
    @Column
    private BigDecimal precio_unitario;
    @Column
    private short unidades_en_stock;
    @Column
    private boolean descontinuado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getUnidad_por_cantidad() {
        return unidad_por_cantidad;
    }

    public void setUnidad_por_cantidad(String unidad_por_cantidad) {
        this.unidad_por_cantidad = unidad_por_cantidad;
    }

    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public short getUnidades_en_stock() {
        return unidades_en_stock;
    }

    public void setUnidades_en_stock(short unidades_en_stock) {
        this.unidades_en_stock = unidades_en_stock;
    }

    public boolean isDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(boolean descontinuado) {
        this.descontinuado = descontinuado;
    }
    
    
}
