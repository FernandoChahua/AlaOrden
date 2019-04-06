package com.myorg.core.entity;

import java.util.List;

public class Producto {

    private int idProducto;

    private String nombre;

    private String marca;

    private String descripcion;
    
    private float peso;
    
    private String categoria;
    
    private List<Franquicia> franquicias;


    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Franquicia> getFranquicias() {
        return franquicias;
    }

    public void setFranquicias(List<Franquicia> franquicias) {
        this.franquicias = franquicias;
    }
}