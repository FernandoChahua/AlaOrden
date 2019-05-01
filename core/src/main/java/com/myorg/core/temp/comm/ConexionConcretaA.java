package com.myorg.core.temp.comm;

import com.myorg.core.temp.comm.ext.ProductoExtA;
import com.myorg.core.temp.comm.ext.RepositoryExt;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

//AdapterConcreto
public class ConexionConcretaA extends ConexionInventario {

    //adaptee
    RepositoryExt inv;

    private Map<String, InfoProd> infoProds;

    @Override
    public void open() {
        //TODO: implementar
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        //TODO.definir metodo cerrar en base al tipo de objeto
        //this.conexion.close();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mapearProductos() {
        this.open();
        
        //TODO: Obtener lista completa que contiene precio, stock y codRef;
        //FIXME: tipo de entidad con los datos (no puede ser entidad Producto), de preferencia tipos basicos
        List<ProductoExtA> list = inv.findAll();

        for (ProductoExtA obj : list) {
            //Extraer datos del objeto y generar 
            String codRef = null;
            BigDecimal precio = null;
            int stock = 0;
            infoProds.put(codRef, new InfoProd(precio, stock));
        }
    }

    @Override
    public InfoProd recuperarInf(String codRef) {
        //TODO implmentar algoritmo precio producto
        try {
            //verifica que se haya llenado el hastable
            if (!infoProds.isEmpty() && infoProds != null) {
                return infoProds.getOrDefault(codRef, new InfoProd(BigDecimal.ZERO, 0));
            } //si no se está mapeado, se recupera individualemnte
            else {
                this.open();

                this.close();
            }
        } catch (Exception e) {

            return null;
        }
    }
}
