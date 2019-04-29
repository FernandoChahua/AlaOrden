package com.myorg.web.controller;

import com.myorg.core.entity.Usuario;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.Tarjeta;
import com.myorg.core.service.*;
import javax.faces.view.ViewScoped;
import org.myorg.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@ViewScoped
public class TarjetaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ITarjetaService tarjetaService;

    @Inject
    private IUsuarioService clienteService;

    private List<Tarjeta> tarjetas;
    private Tarjeta tarjeta;
    private Tarjeta tarjetaSel;

    private Usuario usuario;
    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {

        tarjeta = new Tarjeta();
        tarjetaSel = new Tarjeta();
        usuario = new Usuario();
        this.loadTarjetas();
        this.loadUsuarios();
    }

    public void loadTarjetas() {
        try {
            this.tarjetas = tarjetaService.findAll();
        } catch (Exception e) {

        }
    }

    public void loadUsuarios() {
        try {
            this.usuarios = clienteService.findAll();
        } catch (Exception e) {

        }
    }

    public void saveTarjeta() {
        try {
            if (tarjeta.getIdTarjeta() != null) {
                tarjeta.setUsuario(usuario);
                tarjetaService.update(tarjeta);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                tarjeta.setUsuario(usuario);
                tarjetaService.insert(tarjeta);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadTarjetas();
            cleanForm();
        } catch (Exception e) {
            Message.messageError("Error TarjetaType :" + e.getMessage());
        }
    }

    public void editTarjeta() {
        try {
            if (this.tarjetaSel.getIdTarjeta() != null) {
                this.tarjeta = this.tarjetaSel;
                for (Usuario cl : usuarios) {
                    if (tarjeta.getUsuario().getIdUsuario() == cl.getIdUsuario()) {
                        this.usuario = cl;
                        break;
                    }
                }

            } else {
                Message.messageInfo("Debe seleccionar una tarjeta");
            }
        } catch (Exception e) {
            Message.messageError("Error tarjeta :" + e.getMessage());
        }

    }

    public void deleteTarjeta() {
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

    public void selectTarjeta(SelectEvent e) {
        this.tarjetaSel = (Tarjeta) e.getObject();
    }

    public void cleanForm() {
        this.tarjeta = new Tarjeta();
        this.tarjetaSel = null;
        this.usuario = new Usuario();
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
