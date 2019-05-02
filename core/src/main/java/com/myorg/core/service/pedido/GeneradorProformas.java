package com.myorg.core.service.pedido;

import com.myorg.core.service.comm.InfoProd;
import com.myorg.core.entity.*;
import com.myorg.core.service.comm.ComunicadorInventario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//PENDING: Probar si funciona
public class GeneradorProformas {

    private ComunicadorInventario comm;

    private Map<String, List<DetallePedido>> proformas;

    //filtrado en base a cercania (solo sedes cercanas, Controller o Service)
    private List<Franquicia> proveedores;

    public void generarListas(List<DetallePedido> carrito) {
        if (proveedores != null && !proveedores.isEmpty()) {
            for (Franquicia prov : proveedores) {
                List<DetallePedido> lista = generarListaPorFranquicia(carrito, prov);
                proformas.put(prov.toString(), lista);
            }
        } else {

        }
    }

    private List<DetallePedido> generarListaPorFranquicia(List<DetallePedido> carrito, Franquicia prov) {
        List<DetallePedido> lista = new ArrayList<>();

        //establecer conexion
        comm = ComunicadorInventario.establecerComunicacion(prov.getUrl());

        for (DetallePedido dp : carrito) {

            //empaquetar (incluir precio)
            DetallePedido rpta = empaquetar(dp, prov);
            lista.add(rpta);
        }
        return lista;
    }

    private DetallePedido empaquetar(DetallePedido busq, Franquicia prov) {
        DetallePedido result = new DetallePedido();
        String codRef = null;
        BigDecimal precio = null;
        String mensaje = null;
        int cantidad = 0;

        codRef = getCodRef(busq, prov);

        InfoProd info = comm.recuperarInfoProd(codRef);

        if (info == null) {
            mensaje = "Producto no diponible en " + prov.getNombre();
        }
        //Si el stock no es suficiente
        if (busq.getCantidad() > info.stock) {
            //incluir caso en Regla de negocios
            if (info.stock == 0) {
                mensaje = "No hay stock disponible";
            } else {
                mensaje = "No hay stock suficiente";
            }
            cantidad = info.stock;
        }

        //alamacena: precio, producto y cantidad        
        result.setPrecio(precio);
        result.setProducto(busq.getProducto());
        result.setCantidad(cantidad);
        result.setMensajeError(mensaje);
        return result;
    }

    private String getCodRef(DetallePedido busq, Franquicia prov) {
        String codRef = null;
        for (ProductoFranquicia pf : busq.getProducto().getProductoFranquicias()) {
            if (pf.getFranquicia().getIdFranquicia() == prov.getIdFranquicia()) {
                codRef = pf.getCodReferencia();
                break;
            }
        }
        return codRef;
    }

    public Map<String, List<DetallePedido>> getProformas() {
        return proformas;
    }

    public List<Franquicia> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Franquicia> proveedores) {
        this.proveedores = proveedores;
    }

}
