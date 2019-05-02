package com.myorg.web.controller.crud;

import java.util.ArrayList;
import java.util.List;

import com.myorg.core.entity.Usuario;
import com.myorg.core.service.impl.UsuarioServiceImpl;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.myorg.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsuarioServiceImpl usuarioService;

    private List<Usuario> usuarios;
    private Usuario usuario;
    private Usuario usuarioSel;

    @PostConstruct
    public void init() {
        usuarios = new ArrayList<>();
        usuario = new Usuario();
        usuarioSel = new Usuario();
        this.loadUsuarios();
    }

    public void loadUsuarios() {
        try {
            usuarios = usuarioService.findAll();
        } catch (Exception e) {
            Message.messageError("Error Cliente" + e.getMessage());
        }
    }

    public void saveUsuario() {
        try {
            if (usuario.getIdUsuario() != null) {
                usuarioService.insert(usuario);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                usuarioService.update(usuario);
                Message.messageInfo("Registro guardado exitosamente");
            }
        } catch (Exception e) {
            Message.messageError("Error Usuario" + e.getMessage());
        }
        loadUsuarios();
        cleanForm();
    }

    public void editUsuario() {
        try {
            System.out.println("Customer Selec:" + usuarioSel.getApodo());
            if (this.usuarioSel.getIdUsuario() != null) {
                this.usuario = usuarioSel;
            } else {
                Message.messageInfo("Debe seleccionar un cliente");
                System.out.println("Hola:");
            }
        } catch (Exception e) {
            Message.messageError("Error Usuario :" + e.getMessage());
        }

    }

    public void cleanForm() {
        this.usuario = new Usuario();
        this.usuarioSel = null;
    }

    public void selectUsuario(SelectEvent e) {
        this.usuarioSel = (Usuario) e.getObject();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
