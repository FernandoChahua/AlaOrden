package com.myorg.core.service.comm;

//Adapter Interface

import java.io.Serializable;

public abstract class ComunicadorInventario implements Serializable{
    
    //Factory Method
    public static ComunicadorInventario establecerComunicacion(String url){
        ComunicadorInventario conn = null;
        
        //TODO: Cambiar logica para multiples franquicias
        if (!url.isEmpty()){
            conn = new ComunicadorConcretoA();
        }
        else{
        }
        return conn;
    }
    
    //mapear la informaciòn de TODOS los productos 
    //en un hashtable para reducir siguientes bùsquedas;
    public abstract void mapearProductos();
    
    public abstract void limpiarMapaProductos();
    
    public abstract InfoProd recuperarInfoProd(String codRef);
}
