package com.myorg.core.temp.comm;

//Adapter Interface
public abstract class ConexionInventario {
    
    //Factory Method
    public static ConexionInventario establecerComunicacion(String url){
        ConexionInventario conn = null;
        
        //TODO: Cambiar logica para multiples franquicias
        if (!url.isEmpty()){
            conn = new ConexionConcretaA();
        }
        else{
            
        }
        return conn;
    }
    
    public abstract void open();
    
    public abstract void close();
    
    //mapear la informaciòn de TODOS los productos en un hashtable para reducir siguientes bùsquedas;
    public abstract void mapearProductos();
    
    public abstract InfoProd recuperarInf(String codRef);
}
