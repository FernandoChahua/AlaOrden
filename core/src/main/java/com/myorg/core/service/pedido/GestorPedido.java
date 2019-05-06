package com.myorg.core.service.pedido;

import com.myorg.core.service.payment.InfoPago;
import com.myorg.core.service.payment.PagosService;
import com.myorg.core.entity.*;
import com.myorg.core.service.*;
import com.myorg.core.service.payment.GatewayHelper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*TODO: convertir clases en managedbeans (@Named)
        para hacer inyeccion de dependencias*/
//PENDING: cambiar Nombre (Orden? PedidoService?...)
//GestorPedido DEBE guardarse como atributo de la sesion para que no se pierda al cambiar de vista;
@Deprecated
public class GestorPedido {

    private Pedido pedido;

    private ITarjetaService tarjetaService;
    private IFranquiciaService franquiciaService;

    private PagosService pagosService;

    private GeneradorProformas proformas;

    Map<String, String> detallesPago;

    // -------
    //TODO: decidir si incluye carrito o no FACADE NO SIMPLIFICA CARRITO
    private Carrito carrito;

    public void asignarUsuario(Usuario user) {
        this.pedido = new Pedido();
        this.pedido.setUsuario(user);
    }

    //metodos de acceso directo al carrito (carrito sin setter o getter)
    public void agregarAlCarrito(Producto prod, int cantidad) {
        carrito.agregarProducto(prod, cantidad);
    }

    public void quitarDelCarrito(int index) {
        carrito.eliminarProducto(index);
    }

    public void editarCantidadCarrito(int index, int cantidad) {
        carrito.editarCantidad(index, cantidad);
    }

    public void limpiarCarrito() {
        carrito.vaciarCarrito();
    }

    public List<DetallePedido> obtenerCarrito() {
        return carrito.getLista();
    }

    public Map<String, List<DetallePedido>> cotizarPedido() {
        try {
            proformas.setProveedores(franquiciaService.findAll());
        } catch (Exception e) {
            return new HashMap<>();
        }
        proformas.generarListas(carrito.getLista());
        return proformas.getProformas();
    }

    public List<DetallePedido> detallesPorFranquicia(String nombreFranquicia) {
        if (proformas.getProformas() == null || proformas.getProformas().isEmpty()) {
            proformas.generarListas(carrito.getLista());
        }
        return proformas.getProformas().getOrDefault(nombreFranquicia, new ArrayList<>());
    }

    public BigDecimal subtotalPorFranquicia(String nombreFranquicia) {
        List<DetallePedido> detalles = detallesPorFranquicia(nombreFranquicia);
        return subtotalLista(detalles);
    }

    private BigDecimal subtotalLista(List<DetallePedido> listaCotizada) {
        BigDecimal subtotal = new BigDecimal(0);
        for (DetallePedido d : listaCotizada) {
            subtotal.add(d.getPrecio());
        }
        return subtotal;
    }

    public void elegirFranquicia(Franquicia franquicia) {
        List<DetallePedido> detalles = this.proformas.getProformas().get(franquicia.getNombre());
        this.pedido.setDetalles(detalles);
        this.pedido.setSubtotal(subtotalLista(detalles));
    }

    /* 
        TODO: Metodos para Direccion y PrecioEnvio (RUTASERVICE)
    
    /*
    
    /* TODO: METODOS para Descuento */
    
    
    public void prepararTransaccion(Tarjeta t, InfoPago infoPago) throws Exception {
        if (pedido.getDescuento() == null || pedido.getSubtotal() == null || pedido.getPrecioEnvio() == null) {
            throw new Exception("error en transaccion");
        }

        BigDecimal total = new BigDecimal(0);
        total.add(pedido.getSubtotal());
        total.add(pedido.getPrecioEnvio());
        total.subtract(pedido.getDescuento());
        String user = pagosService.getUser();
        String key = pagosService.getKey();

        detallesPago = GatewayHelper.armarParametroVenta(user, key, t, infoPago, total);
    }

    public Integer confirmarPago() throws Exception {
        Integer rpta = pagosService.pagar(detallesPago);
        if (rpta == null) {
            throw new Exception("No se pudo realizar el pago");
        }
        return rpta;
    }

}
