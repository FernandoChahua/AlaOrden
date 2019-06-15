package com.alaorden.service.impl;

import com.alaorden.model.Categoria;
import com.alaorden.model.Marca;
import com.alaorden.model.Producto;
import com.alaorden.repository.CategoriaRepository;
import com.alaorden.repository.MarcaRepository;
import com.alaorden.repository.ProductoRepository;
import com.alaorden.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    public ProductoRepository productoRepository;
    public CategoriaRepository categoriaRepository;
    public MarcaRepository marcaRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository,CategoriaRepository categoriaRepository,MarcaRepository marcaRepository){
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.marcaRepository = marcaRepository;
    }

    public List<Producto> listProductos(){
        return productoRepository.findAll();
    }
    public List<Categoria> listCategorias(){
        return categoriaRepository.findAll();
    }
    public List<Marca> listMarca(){
        return marcaRepository.findAll();
    }

}
