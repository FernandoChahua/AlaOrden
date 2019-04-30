package com.myorg.core.temp;

import com.myorg.core.entity.*;
import java.util.ArrayList;
import java.util.List;

public class GeneradorProformas {

    //se encarga de conectarse y cotizar
    //PENDING: como atributo
    /* OPCIONES: 
        -una instancia del cominicador (abre y cierra conexion con franquicia una a la vez 
        -multiples instancias (una por franquicia) //ya no sería atributo
        -unica instancia que no cierra conexion (se cambia por otro con un setter)
    */
    private Inventario conn;
    
    //FIXME: como saber cual lista pertenece a X franquicia??
    /*SUGERENCIA:
        cambiarlo a Map<String,List<DetallePedido>> donde el string representa al nombre 
            (deventaja, no iterable, valores se obtiene con el nombre)
    */
    private List<List<DetallePedido>> proformas;
    private List<Franquicia> proveedores;
    
    
    public void GenerarListas(List<DetallePedido> carrito){
        if (proveedores != null && !proveedores.isEmpty()){
            for (Franquicia prov : proveedores){
               //establecer conexion
               
               List<DetallePedido> lista = new ArrayList<>();
               conn.establecerConexion(prov.getUrl());
               for (DetallePedido dp : carrito){
                   //empaquetar (incluir precio)
                   
               }
            }
        }
        
    }

    
    //TODO: Nombre
    private DetallePedido empaquetar(DetallePedido busq, Franquicia prov){
        DetallePedido result = new DetallePedido();
        
        //obtener codReferencia
        String codRef = null;
        for (ProductoFranquicia pf : busq.getProducto().getProductoFranquicias()){
            if (pf.getFranquicia().getIdFranquicia() == prov.getIdFranquicia()){
                codRef = pf.getCodReferencia();
                break;
            }
        }
        
        //TODO: que pasa si no lo encuentra??
        InfoProd info = conn.recuperarInf(codRef);
        
        //TODO: si el stock no es suficiente
        if (busq.getCantidad() > info.stock){
            //incluir caso en Regla de negocios
        }
        
        //alamacena: precio, producto y cantidad        
        result.setPrecio(info.precio); 
        result.setProducto(busq.getProducto());
        result.setCantidad(busq.getCantidad());
        return result;
    }
}
