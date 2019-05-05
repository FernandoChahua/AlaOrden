package com.myorg.web.controller.crud;

import com.myorg.core.entity.Usuario;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.service.*;
import javax.faces.view.ViewScoped;
import com.myorg.util.Message;
import org.primefaces.event.SelectEvent;

@Named
@ViewScoped
public class RolController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IRolService rolService;

    private List<Rol> roles;
    private Rol rol;
    private Rol rolSel;

    @PostConstruct
    public void init() {

        rol = new Rol();
        rolSel = new Rol();
        this.loadRoles();
    }

    public void loadRoles() {
        try {
            this.roles = rolService.findAll();
        } catch (Exception e) {

        }
    }

    public void saveRol() {
        try {
            if (rol.getIdRol()!= null) {
                rolService.update(rol);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                rolService.insert(rol);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadRoles();
            cleanForm();
        } catch (Exception e) {
            Message.messageError("Error TarjetaType :" + e.getMessage());
        }
    }

    public void editRol() {
        try {
            if (this.rolSel.getIdRol()!= null) {
                this.rol = this.rolSel;
            } else {
                Message.messageInfo("Debe seleccionar una tarjeta");
            }
        } catch (Exception e) {
            Message.messageError("Error tarjeta :" + e.getMessage());
        }

    }

    public void deleteRol() {
        try {
            if (this.rolSel != null) {
                rolService.delete(rolSel);
                loadRoles();
                cleanForm();

            } else {

            }
        } catch (Exception e) {

        }
    }

    public void selectRol(SelectEvent e) {
        this.rolSel = (Rol) e.getObject();
    }

    public void cleanForm() {
        this.rol = new Rol();
        this.rolSel = null;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol getRolSel() {
        return rolSel;
    }

    public void setRolSel(Rol rolSel) {
        this.rolSel = rolSel;
    }
}
