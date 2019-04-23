/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.core.service;

/**
 *
 * @author Alexia
 */

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.repository.TarjetaRepositorio;
import com.myorg.core.entity.Tarjeta;


/**
 *
 * @author Alexia
 */
@Named
public class TarjetaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
        private TarjetaRepositorio tarjetaRepositorio;
	
	public void guardarTarjeta(Tarjeta t) {
		tarjetaRepositorio.guardar(t);
	}
	
	public List<Tarjeta> getTodasTarjetas(){
		return tarjetaRepositorio.SeleccionTotal();
	}
	

}

