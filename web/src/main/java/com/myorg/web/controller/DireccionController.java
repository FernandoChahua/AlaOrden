package com.myorg.web.controller;

import com.myorg.core.entity.Pedido;
import com.myorg.util.Message;
import com.myorg.util.SessionHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.event.SelectEvent;

@Named
@ViewScoped
public class DireccionController implements Serializable {
     private static final long serialVersionUID = 1L;
     private String latitud;
     private String longitud;
     private String direccion;
     private String key;
    @PostConstruct
    public void init() {
        try {
            latitud = "";
            longitud="";
            direccion="";
            key="AIzaSyDT3BrfPIJPb8V-JdIlHkUcCaPxza33unY";
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String siguientePaso() {
		String redirect = "Pagos.xhtml";

		return redirect;
	}
    public String getLatitud(){
        return this.latitud;
    }
    public void setLatitud(String latitud){
        this.latitud = latitud;
    }
        public String getLongitud(){
        return this.longitud;
    }
    public void setLongitud(String longitud){
        this.latitud = longitud;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public String getKey()
    {
        return this.key;
    }
    
}

