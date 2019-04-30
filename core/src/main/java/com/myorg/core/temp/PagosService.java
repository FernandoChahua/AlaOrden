package com.myorg.core.temp;

import com.myorg.core.entity.*;

public class PagosService {

    //objeto de conexion proveedor o no?
    
    //Objeto

    //retorna mensaje
    public String iniciarTranasccion(Tarjeta t){
        return "";
    }
    
    //...
    public boolean enviarInformacionPago(Tarjeta t){
        return false;
    }
    
    //lamado externamente luego que la transaccion fue procesada
    public int obtenerRespuesta(Object...objects){
        return -1;
    }
    
    //llamado dentro de validar (opcional)
    public boolean establecerConexion(String url){
        return false;
    }
    //llamado dentro de validar (opcional)
    public void cerrarConexion(){
        
    }
}
