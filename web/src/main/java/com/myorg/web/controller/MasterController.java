package com.myorg.web.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.myorg.core.entity.Usuario;
import com.myorg.util.Message;

@Named
@ViewScoped
public class MasterController implements Serializable {

	private static final long serialVersionUID = 1L;

	public void checkSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Usuario user = (Usuario) context.getExternalContext().getSessionMap().get("user");

			if (user == null) {
				context.getExternalContext().redirect("./../IniciarSesion.xhtml");
			}
			
		} catch (Exception e) {
			Message.messageError("Error Master :" + e.getMessage());
		}
	}

	public void signOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

}
