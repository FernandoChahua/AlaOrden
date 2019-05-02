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

import org.primefaces.event.SelectEvent;
import org.myorg.util.Message;

@Named
@ViewScoped
public class DetallePedidoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IPedidoService pedidoService;

    @Inject
    private IProductoService productoService;

    private DetallePedido detallePedido;
    private DetallePedido detallePedidoSelect;
    private List<DetallePedido> detallePedidos;

    private List<Pedido> pedidos;
    private Pedido pedido;

    private List<Producto> productos;
    private Producto producto;

    @PostConstruct
    public void init() {
        detallePedido = new DetallePedido();
        detallePedidoSelect = new DetallePedido();

        pedido = new Pedido();

        producto = new Producto();

        this.loadDetallePedidos();
        this.loadPedidos();
        this.loadProductos();
    }

    public void loadDetallePedidos() {
        try {
            this.detallePedidos = pedido.getDetalles();
        } catch (Exception e) {
            Message.messageError("Error Pedido :" + e.getMessage());
        }
    }

    public void loadPedidos() {
        try {
            pedidos = pedidoService.findAll();
        } catch (Exception e) {
            Message.messageError("Error Usuario" + e.getMessage());
        }
    }

    public void loadProductos() {
        try {
            this.productos = productoService.findAll();
        } catch (Exception e) {
        }
    }

    public void saveDetallePedido() {
        try {
            detallePedido.setPedido(pedido);
            if (detallePedido.getPk() == null) {
                detallePedido.setProducto(producto);
            }
            pedidoService.update(pedido);
            Message.messageInfo("Registro actualizado exitosamente");
            loadDetallePedidos();
            cleanForm();
        } catch (Exception e) {
            Message.messageError("Error Pedido :" + e.getStackTrace());
        }
    }

    public void editDetallePedido() {
        try {
            if (this.detallePedidoSelect != null) {
                this.detallePedido = detallePedidoSelect;
                for (Producto p : productos) {
                    if (detallePedido.getProducto().getIdProducto() == p.getIdProducto()) {
                        this.producto = p;
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
            if (this.detallePedidoSelect != null) {
                pedido.getDetalles().remove(detallePedidoSelect);
                pedidoService.update(pedido);
                loadDetallePedidos();
                cleanForm();

            } else {

            }
        } catch (Exception e) {

        }
    }

    public void selectPedido(SelectEvent e) {
        this.detallePedidoSelect = (DetallePedido) e.getObject();
    }

    public void cleanForm() {
        Integer idPedido = pedido.getIdPedido();
        loadPedidos();

        for (Pedido p : pedidos) {
            if (p.getIdPedido() == idPedido) {
                pedido = p;
                break;
            }
        }
        this.detallePedido = new DetallePedido();
        this.detallePedidoSelect = null;
        this.producto = new Producto();
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    public DetallePedido getDetallePedidoSelect() {
        return detallePedidoSelect;
    }

    public void setDetallePedidoSelect(DetallePedido detallePedidoSelect) {
        this.detallePedidoSelect = detallePedidoSelect;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
}
