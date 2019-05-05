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
import javax.transaction.Transactional;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUsuarioService usuarioService;
	private Usuario usuario;
        private Usuario nuevo;
        private String ErrorSignIn = "";
        private String ErrorSignUp = "";

	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
                this.nuevo = new Usuario();                
	}

	public String authentication() {
		String redirect = "HomePage.xhtml";
		try {
			Usuario userFound = usuarioService.validarContraseña(usuario);

			if (userFound != null){

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
				redirect = "PaginaInicio.xhtml";
			} else {
				ErrorSignIn = "Credenciales incorrectas";

			}
		} catch (Exception e) {
			Message.messageError("Credenciales incorrectas" + e.getMessage());
			System.out.println(e.getMessage());
		}

		return redirect;
	}
        
        @Transactional
        public String registrar(){
                try{
                    boolean newUser = usuarioService.Registrar(nuevo);
                    
                    if(newUser){
                        ErrorSignUp = "Registrado exitosamente";
                    }
                    else ErrorSignUp = "Usuario o Email invalidos";
                } catch(Exception e){
                        Message.messageError("Error al registrar" + e.getMessage());
			System.out.println(e.getMessage());
                }
                return "HomePage.xhtml";
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public String getErrorSignIn() {
            return ErrorSignIn;
        }

        public void setErrorSignIn(String ErrorSignIn) {
            this.ErrorSignIn = ErrorSignIn;
        }

        public String getErrorSignUp() {
            return ErrorSignUp;
        }

        public void setErrorSignUp(String ErrorSignUp) {
            this.ErrorSignUp = ErrorSignUp;
        }
        
        public Usuario getNuevo() {
            return nuevo;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public void setNuevo(Usuario nuevo) {
            this.nuevo = nuevo;
        }
        

}
