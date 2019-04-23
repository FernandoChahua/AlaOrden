package com.myorg.web.controller;

import com.myorg.core.entity.Franquicia;
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
public class FranquiciaController implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private IFranquiciaService franquiciaService;
    
    private Franquicia franquicia;
    private Franquicia franquiciaSel;
    private List<Franquicia> franquicias;

    @PostConstruct
    public void init(){
        franquicia = new Franquicia();
        franquiciaSel = new Franquicia();
        loadFranquicias();
    }
    
    public void loadFranquicias(){
        try {
            this.franquicias = franquiciaService.findAll();
	} catch (Exception e) {
            
	}
    } 
   
    public void saveFranquicia() {
		try {
			if (franquicia.getIdFranquicia()!= 0) {
				franquiciaService.update(franquicia);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				franquiciaService.insert(franquicia);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadFranquicias();
			cleanForm();
		} catch (Exception e) {
			Message.messageError("Error FranquiciaType :" + e.getMessage());
		}
	}

	public void editFranquicia() {
		try {
			if (this.franquiciaSel.getIdFranquicia() > 0) {
				this.franquicia = this.franquiciaSel;
				
			} else {
				Message.messageInfo("Debe seleccionar un  franquiciao");
			}
		} catch (Exception e) {
			Message.messageError("Error Franquicia :" + e.getMessage());
		}

	}

	public void deleteFranquicia() {
		try {
			if (this.franquiciaSel != null) {
				franquiciaService.delete(franquiciaSel);
				loadFranquicias();
				cleanForm();

			} else {

			}
		} catch (Exception e) {

		}
	}

	public void selecFranquicia(SelectEvent e) {
		this.franquiciaSel = (Franquicia) e.getObject();
	}

	public void cleanForm() {
		this.franquicia = new Franquicia();
		this.franquiciaSel = null;
	}

	public Franquicia getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(Franquicia franquicia) {
		this.franquicia = franquicia;
	}

	public Franquicia getFranquiciaSel() {
		return franquiciaSel;
	}

	public void setFranquiciaSel(Franquicia franquiciaSel) {
		this.franquiciaSel = franquiciaSel;
	}

	public List<Franquicia> getFranquicias() {
		return franquicias;
	}

	public void setFranquicias(List<Franquicia> franquicias) {
		this.franquicias = franquicias;
	}

    
}
