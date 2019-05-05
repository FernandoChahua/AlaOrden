package com.myorg.web.controller;


import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.Usuario;
import com.myorg.core.service.IUsuarioService;
import com.myorg.util.Message;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUsuarioService usuarioService;
	private Usuario usuario;

	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
	}

	public String authentication() {
		String redirect = null;

		try {
			Usuario userFound = usuarioService.validarContraseña(usuario);

			if (userFound != null && userFound.isActivo()){

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
				redirect = "/protected/orders?faces-redirect=true";
			} else {
				Message.messageError("Credenciales incorrectas");

			}
		} catch (Exception e) {
			Message.messageError("Credenciales incorrectas" + e.getMessage());
			System.out.println(e.getMessage());
		}

		return redirect;
	}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

        

}
