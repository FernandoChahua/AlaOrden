package com.alaorden.service;

import com.alaorden.model.Categoria;
import com.alaorden.model.Marca;
import com.alaorden.model.Producto;

import java.util.List;

public interface ProductoService {
     List<Producto> listProductos();
     List<Categoria> listCategorias();
     List<Marca> listMarca();
}
