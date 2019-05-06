package com.myorg.core.service.pedido;

import com.myorg.core.service.comm.InfoProd;
import com.myorg.core.entity.*;
import com.myorg.core.repository.impl.ProductoRepositoryImpl;
import com.myorg.core.service.comm.ComunicadorInventario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.inject.Inject;
import javax.inject.Named;

//PENDING: Probar si funciona
@Named
public class GeneradorProformas implements Serializable {

    @Inject
    private ComunicadorInventario comm;

    private Map<String, List<DetallePedido>> proformas;

    //filtrado en base a cercania (solo sedes cercanas, Controller o Service)
    private List<Franquicia> proveedores;
    //FIXME: TESTING
    @Inject
    ProductoRepositoryImpl pR;
    
    
    //FIXME: TESTING
    public void testMe(){
        
        List<Producto> prods = null;
        try{
            prods = pR.findAll();
        }catch(Exception e){
            return;
        }
        proformas = new HashMap<>();
        
        List<String> prov = new ArrayList<>();
        prov.add("Metro");
        prov.add("Plaza Vea");
        prov.add("Tottus");
        
        for (String p : prov){
            List<DetallePedido> list = new ArrayList<>();
            for (Producto pr : prods){
                DetallePedido dp = new DetallePedido();
                dp.setProducto(pr);
                dp.setCantidad(1);
                dp.setPrecio(new BigDecimal(new Random().nextInt(3) + 5));
                
                list.add(dp);
            }
            proformas.put(p, list);
        }
    }
    
    public void generarListas(List<DetallePedido> carrito) {
        if (proveedores != null && !proveedores.isEmpty()) {
            for (Franquicia prov : proveedores) {
                List<DetallePedido> lista = generarListaPorFranquicia(carrito, prov);
                proformas = new HashMap<>();
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

    public List<DetallePedido> buscarProforma(String franquicia) {
        return proformas.get(franquicia);
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

    public BigDecimal subtotalPorFranquicia(String nombreFranquicia) {
        List<DetallePedido> detalles = proformas.get(nombreFranquicia);
        return subtotalLista(detalles);
    }

    private BigDecimal subtotalLista(List<DetallePedido> listaCotizada) {
        BigDecimal subtotal = new BigDecimal(0);
        for (DetallePedido d : listaCotizada) {
            BigDecimal importe = d.getPrecio().multiply(new BigDecimal(d.getCantidad()));
            subtotal = subtotal.add(importe);
        }
        return subtotal;
    }

}
