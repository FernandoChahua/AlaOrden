package com.myorg.core.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.Producto;
import com.myorg.core.repository.ProductoRepository;

@Named
public class ProductoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProductoRepository productoRepository;
	
	public void saveProducto(Producto p) {
		productoRepository.save(p);
	}
	
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}
	

}
