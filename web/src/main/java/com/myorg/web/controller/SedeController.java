package com.myorg.web.controller;

import com.myorg.core.entity.Franquicia;
import com.myorg.core.entity.Sede;
import com.myorg.core.service.IFranquiciaService;
import com.myorg.core.service.ISedeService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.myorg.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@ViewScoped
public class SedeController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private IFranquiciaService franquiciaSerivice;
    
    @Inject 
    private ISedeService sedeService;
    
    private Sede sede;
    private Sede sedeSel;
    private List<Sede> sedes;
    
    private Franquicia franquicia;
    private List<Franquicia> franquicias;
    
    
    @PostConstruct
	public void init() {
		sede = new Sede();
		sedeSel = new Sede();

		this.loadFranquicias();
		this.loadSedes();
	}

	public void loadFranquicias() {
		try {
			this.franquicias = franquiciaSerivice.findAll();
		} catch (Exception e) {

		}
	}

	public void loadSedes() {
		try {
			this.sedes = sedeService.findAll();
		} catch (Exception e) {

		}
	}

	public void saveSede() {
		try {
			if (sede.getIdSede()!= 0) {
				sede.setFranquicia(franquicia);
				sedeService.update(sede);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				sede.setFranquicia(franquicia);
				sedeService.insert(sede);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadSedes();
			cleanForm();
		} catch (Exception e) {
			Message.messageError("Error SedeoType :" + e.getMessage());
		}
	}

	public void editSede() {
		try {
			if (this.sedeSel.getIdSede()> 0) {
				this.sede = this.sedeSel;
				// this.sede.setSedeType(this.sedeSel.getSedeType());
			} else {
				Message.messageInfo("Debe seleccionar un  sedeo");
			}
		} catch (Exception e) {
			Message.messageError("Error Sede :" + e.getMessage());
		}

	}

	public void deleteSede() {
		try {
			if (this.sedeSel != null) {
				sedeService.delete(sedeSel);
				loadSedes();
				cleanForm();

			} else {

			}
		} catch (Exception e) {

		}
	}

	public void selecSede(SelectEvent e) {
		this.sedeSel = (Sede) e.getObject();
	}

	public void cleanForm() {
		this.sede = new Sede();
		this.sedeSel = null;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Sede getSedeSel() {
		return sedeSel;
	}

	public void setSedeSel(Sede sedeSel) {
		this.sedeSel = sedeSel;
	}

	public List<Sede> getSedes() {
		return sedes;
	}

	public void setSedes(List<Sede> sedes) {
		this.sedes = sedes;
	}

	public List<Franquicia> getCategories() {
		return franquicias;
	}

	public void setCategories(List<Franquicia> franquicias) {
		this.franquicias = franquicias;
	}

	public Franquicia getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(Franquicia franquicia) {
		this.franquicia = franquicia;
	}
    
}
