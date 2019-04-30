package com.myorg.core.temp;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

//TODO: cambiar nombre
//establece comunicacion con la base de datos de terceros (franquicias)
public class Inventario {

    //TODO: definir tipo de objeto
    private Object conexion;

    //Hash table de la info(stock y precio) todos los productos de una franquicia
    //Llave: codRef
    private Map<String, InfoProd> infoProds;

    Inventario() {
    }

    Inventario(String url) {
        establecerConexion(url);
    }

    //url de franquicia permite conectarnos
    //requiere clase que retorne objeto conexion
    public void establecerConexion(String url) {
        //TODO implementar
        this.conexion = null;
    }

    public <T> void getInformacionProductos() throws Exception {
        //TODO: implementar
        if (conexion == null) {
            return; //PENDING: termina funcion o ttira una Excepcion
        }
        //TODO: Obtener lista completa que contiene precio, stock y codRef;
        //FIXME: tipo de entidad con los datos (no puede ser entidad Producto), de preferencia tipos basicos
        List<T> list = null;
        
        for (T obj : list) {
            //Extraer datos del objeto y generar 
            String codRef = null;
            BigDecimal precio = null;
            int stock = 0;
            infoProds.put(codRef, new InfoProd(precio, stock));
        }
    }

    //metodo opcional??
    void cerrarConexion() {
        //TODO.definir metodo cerrar en base al tipo de objeto
        //this.conexion.close();
    }

    public InfoProd recuperarInf(String codRef) {
        //TODO implmentar algoritmo precio producto
        try {
            //verficia que se haya llenado el hastable
            if (infoProds.isEmpty() || infoProds == null) {
                getInformacionProductos();
            }

        } catch (Exception e) {

        }
        return infoProds.get(codRef);
    }
}
    

