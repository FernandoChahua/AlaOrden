package com.myorg.core.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.repository.impl.*;
import com.myorg.core.entity.*;


@Named
public class TarjetaServiceImpl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
        private TarjetaRepositorioImpl tarjetaRepositorio;
	
	public void insert(Tarjeta t) {
		tarjetaRepositorio.insert(t);
	}
	
	public List<Tarjeta> findAll(){
		return tarjetaRepositorio.SeleccionTotal();
	}
	

}

