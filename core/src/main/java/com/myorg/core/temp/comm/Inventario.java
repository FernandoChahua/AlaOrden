package com.myorg.core.temp.comm;

import com.myorg.core.temp.comm.ext.RepositoryExt;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

//TODO: cambiar nombre
//establece comunicacion con la base de datos de terceros (franquicias)

public class Inventario {

    //TODO: definir tipo de objeto
    private RepositoryExt conexion;

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
        //this.conexion = new RepositoryExt(url);
    }

    //
    public <T> void getInformacionProductos() throws Exception {

    }


    void cerrarConexion() {

    }

    public InfoProd recuperarInf(String codRef) {
        
    }
}
