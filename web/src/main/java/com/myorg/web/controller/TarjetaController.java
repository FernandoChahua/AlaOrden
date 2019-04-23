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
import com.myorg.core.entity.Franquicia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.Tarjeta;
import com.myorg.core.service.ITarjetaService;
import com.myorg.core.service.impl.TarjetaServiceImpl;
import org.myorg.util.Message;
import org.primefaces.event.SelectEvent;



/**
 *
 * @author Alexia
 */
@Named
@SessionScoped
public class TarjetaController implements Serializable{
    
    	private static final long serialVersionUID = 1L;
	 
        @Inject
	private TarjetaServiceImpl tarjetaService;
	
	
	private List<Tarjeta> tarjetas;
	private Tarjeta tarjeta;
        private Tarjeta tarjetaSel;

	@PostConstruct
	public void init() {
		
		tarjeta=new Tarjeta();
                tarjetaSel=new Tarjeta();
		this.loadTarjetas();
	}
	
	  public void loadTarjetas() {
		try {
			this.tarjetas = tarjetaService.findAll();
		} catch (Exception e) {

		}
	}
	
	
	
        
	public void saveTarjeta() {
		try {
			if (tarjeta.getIdTarjeta() != 0) {
				
				tarjetaService.update(tarjeta);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				
				tarjetaService.insert(tarjeta);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadTarjetas();
			cleanForm();
		} catch (Exception e) {
			Message.messageError("Error TarjetaType :" + e.getMessage());
		}
	}
        
        public void editController() {
		try {
			if (this.tarjetaSel.getIdTarjeta() > 0) {
				this.tarjeta = this.tarjetaSel;
				
			} else {
				Message.messageInfo("Debe seleccionar una tarjeta");
			}
		} catch (Exception e) {
			Message.messageError("Error tarjeta :" + e.getMessage());
		}

	}

	public void deleteFranquicia() {
		try {
			if (this.tarjetaSel != null) {
				tarjetaService.delete(tarjetaSel);
				loadTarjetas();
				cleanForm();

			} else {

			}
		} catch (Exception e) {

		}
	}
	
        public void selecFranquicia(SelectEvent e) {
		this.tarjetaSel = (Tarjeta) e.getObject();
	}

	public void cleanForm() {
		this.tarjeta = new Tarjeta();
		this.tarjetaSel = null;
	}

	
public Tarjeta getTarjeta() {
		return tarjeta;
	}
	
	

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
        
        public Tarjeta getTarjetaSel() {
		return tarjetaSel;
	}

	public void setTarjetaSel(Tarjeta tarjetaSel) {
		this.tarjetaSel = tarjetaSel;
	}
        
        public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}
        public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}


    
}
