package com.myorg.web.controller;

import com.myorg.core.entity.Usuario;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.service.*;
import javax.faces.view.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.myorg.util.Message;

@Named
@ViewScoped
public class PedidoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IPedidoService pedidoService;

    @Inject
    private ISedeService sedeService;

    @Inject
    private IUsuarioService usuarioService;

    private List<Pedido> pedidos;
    private Pedido pedidoSelect;
    private Pedido pedido;

    private List<Usuario> usuarios;
    private Usuario usuario;

    private List<Sede> sedes;
    private Sede sede;

    @PostConstruct
    public void init() {
        pedido = new Pedido();
        pedidoSelect = new Pedido();
        usuario = new Usuario();
        sede = new Sede();

        this.loadPedidos();
        this.loadUsuarios();
        this.loadSedes();
    }

    public void loadPedidos() {
        try {
            this.pedidos = pedidoService.findAll();
        } catch (Exception e) {
            Message.messageError("Error Pedido :" + e.getMessage());
        }
    }

    public void loadUsuarios() {
        try {
            usuarios = usuarioService.findAll();
        } catch (Exception e) {
            Message.messageError("Error Usuario" + e.getMessage());
        }
    }

    public void loadSedes() {
        try {
            this.sedes = sedeService.findAll();
        } catch (Exception e) {
        }
    }

    public void savePedido() {
        try {
            pedido.setUsuario(usuario);
            pedido.setSede(sede);

            if (pedido.getIdPedido() != null) {
                pedidoService.update(pedido);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                pedidoService.insert(pedido);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadPedidos();
            cleanForm();
        } catch (Exception e) {
            Message.messageError("Error Pedido :" + e.getStackTrace());
        }
    }

    public void editPedido() {
        try {
            if (this.pedidoSelect != null) {
                this.pedido = pedidoSelect;
                for (Usuario u : usuarios) {
                    if (pedido.getUsuario().getIdUsuario() == u.getIdUsuario()) {
                        this.usuario = u;
                        break;
                    }
                }
                for (Sede s : sedes) {
                    if (pedido.getSede().getIdSede()== s.getIdSede()) {
                        this.sede = s;
                        break;
                    }
                }
            } else {
                Message.messageInfo("Debe seleccionar una categoria");
            }
        } catch (Exception e) {
            Message.messageError("Error Pedido :" + e.getMessage());
        }

    }

    public void deletePedido() {
        try {
            if (this.pedidoSelect != null) {
                pedidoService.delete(pedidoSelect);
                loadPedidos();
                cleanForm();

            } else {

            }
        } catch (Exception e) {

        }
    }

    public void selectPedido(SelectEvent e) {
        this.pedidoSelect = (Pedido) e.getObject();
    }

    public void cleanForm() {
        this.pedido = new Pedido();
        this.pedidoSelect = null;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedidoSelect() {
        return pedidoSelect;
    }

    public void setPedidoSelect(Pedido pedidoSelect) {
        this.pedidoSelect = pedidoSelect;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
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

    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    
}
