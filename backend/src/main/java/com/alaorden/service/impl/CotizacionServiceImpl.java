package com.alaorden.service.impl;

import com.alaorden.model.*;
import com.alaorden.repository.ProductoFranquiciaRepository;
import com.alaorden.service.CotizacionService;
import com.alaorden.service.PedidoService;
import com.alaorden.util.MetroProductData;
import com.alaorden.util.ProductData;
import com.alaorden.util.ProductDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CotizacionServiceImpl implements CotizacionService {

    private ProductoFranquiciaRepository productoFranquiciaRepository;
    private ProductDataFactory productDataFactory;

    @Autowired
    public CotizacionServiceImpl(ProductoFranquiciaRepository productoFranquiciaRepository) {
        this.productoFranquiciaRepository = productoFranquiciaRepository;
    }



    public List<Pedido> generarListas(List<CarritoItem> carrito, Map<Sede,BigDecimal> disponibles) {

        List<Sede> proveedores = (List)disponibles.keySet();

        List<Pedido> proformas = new ArrayList();

        if (proveedores != null && !proveedores.isEmpty()) {

            for (Sede prov : proveedores) {
                List<DetallePedido> lista = generarListaPorFranquicia(carrito, prov.getFranquicia());

                //FIXME: pls
                //TODO: no puedo :'(
                Pedido pe = new Pedido();

                BigDecimal subTotal = BigDecimal.valueOf(0);

                for (DetallePedido dp : lista){
                    subTotal = subTotal.add(dp.getPrecio());
                }

                BigDecimal precioEnvio = disponibles.get(prov);

                pe.setPrecioEnvio(precioEnvio);
                pe.setSede(prov);
                pe.setDetallePedidos(lista);
                pe.setSubTotal(subTotal);


                proformas.add(pe);
            }
        } else {
            //No se hallaron proveedores
        }
        return proformas;
    }

    private List<DetallePedido> generarListaPorFranquicia(List<CarritoItem> carrito, Franquicia prov) {
        List<DetallePedido> lista = new ArrayList<>();

        //establecer conexion
        productDataFactory = new ProductDataFactory(prov);

        for (CarritoItem item : carrito) {

            //empaquetar (incluir precio)
            DetallePedido rpta = empaquetar(item, prov);
            lista.add(rpta);
        }
        return lista;
    }

    private DetallePedido empaquetar(CarritoItem busq, Franquicia prov) {
        DetallePedido result = new DetallePedido();
        String codRef = null;
        BigDecimal precio = null;
        String mensaje = null;
        int cantidad = 0;

        codRef = getCodRef(busq, prov);


        //FIXME: fix logic
        ProductData info = null;
        try {
            info = productDataFactory.fecthProductData(codRef);
        } catch (IOException e){

        }

        if (!info.validate()) {
            mensaje = "Producto no diponible en " + prov.getNombre();
        }
        //Si el stock no es suficiente
        if (busq.getCantidad() > info.getStock()) {
            //incluir caso en Regla de negocios
            if (info.getStock() == 0) {
                mensaje = "No hay stock disponible";
            } else {
                mensaje = "No hay stock suficiente";
            }
            cantidad = info.getStock();
        }

        //almacena: precio, producto y cantidad
        result.setPrecio(precio);
        result.setProducto(busq.getProducto());
        result.setCantidad(cantidad);
        return result;
    }

    private String getCodRef(CarritoItem busq, Franquicia prov) {
        String codRef = null;
        for (ProductoFranquicia pf : busq.getProducto().getProductosFranquicia()) {
            if (pf.getFranquicia().getIdFranquicia() == prov.getIdFranquicia()) {
                codRef = pf.getCodReferencia();
                break;
            }
        }
        return codRef;
    }

}
