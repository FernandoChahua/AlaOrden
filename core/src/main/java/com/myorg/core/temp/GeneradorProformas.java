package com.myorg.core.temp;

import com.myorg.core.temp.comm.InfoProd;
import com.myorg.core.entity.*;
import com.myorg.core.temp.comm.ConexionInventario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeneradorProformas {

    private ConexionInventario conn;

    private Map<String, List<DetallePedido>> proformas;

    //filtrado en base a cercania (solo sedes cercanas, Controller o Service)
    private List<Franquicia> proveedores;

    public void GenerarListas(List<DetallePedido> carrito) {
        if (proveedores != null && !proveedores.isEmpty()) {
            for (Franquicia prov : proveedores) {
                List<DetallePedido> lista = new ArrayList<>();

                //establecer conexion
                conn = ConexionInventario.establecerComunicacion(prov.getUrl());
                conn.open();

                for (DetallePedido dp : carrito) {

                    //empaquetar (incluir precio)
                    DetallePedido rpta = empaquetar(dp, prov);
                    lista.add(rpta);
                }
                proformas.put(prov.toString(), lista);
                conn.close();
            }
        } else {

        }
    }

    //PENDING: Nombre
    private DetallePedido empaquetar(DetallePedido busq, Franquicia prov) {
        DetallePedido result = new DetallePedido();
        String codRef = null;
        BigDecimal precio = null;
        String mensaje = null;
        int cantidad = 0;

        //obtener codReferencia
        codRef = getCodRef(busq, prov);

        InfoProd info = conn.recuperarInf(codRef);
        
        if (info == null) {
            //TODO: que pasa si no lo encuentra??
        }
        
        //TODO: si el stock no es suficiente
        if (busq.getCantidad() > info.stock) {
            //incluir caso en Regla de negocios

        }

        //alamacena: precio, producto y cantidad        
        result.setPrecio(precio);
        result.setProducto(busq.getProducto());
        result.setCantidad(busq.getCantidad());
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

}
