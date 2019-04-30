/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.core.temp.conexioninv;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import javax.persistence.*;

import com.myorg.core.temp.*;
/**
 *
 * @author Alexia
 */
public class ConexionInv {
    
   private Object conexion;
    
   
    public boolean abrirConexion(String url){
        return false;
    }
   
    public void cerrarConexion(){
        this.conexion = null;
        
    }
    public void obtenerInformacionTotal(Inventario i) throws Exception{
        i.getInformacionProductos();
        
    }
    public void obtenerPrecio(Inventario i) throws Exception{
       // i.recuperarPrecio();
        
    }
       public void obtenerStock(Inventario i) throws Exception{
       // i.recuperarcodRef();
        
    }
         public void obtenercodRef(Inventario i) throws Exception{
       // i.getInformacionProductos();
        
    }
      
    
}
