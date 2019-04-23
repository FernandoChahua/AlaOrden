package com.myorg.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.Producto;
import com.myorg.core.service.impl.ProductoServiceImpl;

@Named
@SessionScoped
public class ProductoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProductoServiceImpl productoService;
	
	
	private List<Producto> productos;
	private Producto producto;

	@PostConstruct
	public void init() {
		productos=new ArrayList<>();
		producto=new Producto();
		this.getAllProductos();
	}
	
	
	public void getAllProductos() {
            try {
		productos = productoService.findAll();
            } catch(Exception e){
                
            }
	}
	
	public String newProducto() {
		return "newProducto?faces-redirect=true";
	}
	
	public String saveProducto() {
		String rpta="";
		try {
			productoService.insert(producto);
			this.getAllProductos();
			rpta="visorProducto?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rpta;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
