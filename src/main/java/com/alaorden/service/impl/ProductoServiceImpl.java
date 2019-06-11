package com.alaorden.service.impl;

import com.alaorden.model.Categoria;
import com.alaorden.model.Marca;
import com.alaorden.model.Producto;
import com.alaorden.repository.CategoriaRepository;
import com.alaorden.repository.MarcaRepository;
import com.alaorden.repository.ProductoRepository;
import com.alaorden.service.ProductoService;

import java.util.List;

public class ProductoServiceImpl implements ProductoService {
    public ProductoRepository productoRepository;
    public CategoriaRepository categoriaRepository;
    public MarcaRepository marcaRepository;


    public List<Producto> listProductos(){

        return null;
    }
    public List<Categoria> listCategorias(){

        return null;
    }
    public List<Marca> listMarca(){

        return null;
    }
}
