package com.myorg.core.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.impl.*;

@Named
public class ProductoServiceImpl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProductoRepositoryImpl productoRepository;
	
	public void insert(Producto p) {
		productoRepository.insert(p);
	}
	
	public List<Producto> findAll(){
		return productoRepository.findAll();
	}
	

}
