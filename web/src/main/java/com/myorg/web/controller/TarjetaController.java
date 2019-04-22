/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.web.controller;

/**
 *
 * @author Alexia
 */
import com.myorg.core.entity.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.Tarjeta;
import com.myorg.core.service.TarjetaService;



/**
 *
 * @author Alexia
 */
@Named
@SessionScoped
public class TarjetaController implements Serializable{
    
    	private static final long serialVersionUID = 1L;
	 
        @Inject
	private TarjetaService tarjetaService;
	
	
	private List<Tarjeta> tarjetas;
	private Tarjeta tarjeta;

	@PostConstruct
	public void init() {
		tarjetas=new ArrayList<>();
		tarjeta=new Tarjeta();
                tarjeta.setCliente(new Cliente());
		this.getTodasTarjetas();
	}
	
	
	public void getTodasTarjetas() {
		tarjetas=tarjetaService.getTodasTarjetas();
	}
	
	public String newTarjeta() {
		return "newTarjeta?faces-redirect=true";
	}
	
	public String guardarTarjeta() {
		String rpta="";
		try {
			tarjetaService.guardarTarjeta(tarjeta);
			this.getTodasTarjetas();
			rpta="visorTarjeta?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rpta;
	}
	
	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

    
}
