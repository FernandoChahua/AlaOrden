package com.myorg.core.temp;

import com.myorg.core.entity.*;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    
    private List<DetallePedido> lista;
    
    public Carrito(){
        lista = new ArrayList<>();
    }

    //genera detallepedido y lo añade
    public void agregarProducto(Producto p, int cantidad){
        DetallePedido dp = new DetallePedido();
        dp.setProducto(p);
        dp.setCantidad(cantidad);
        lista.add(dp);
    }

    //retira producto de la lista (indice o objeto?)
    public void eliminarProducto(int index){
        lista.remove(index);
    }

    //permite cambiar la cantidad
    public void editarCantidad(int index, int cantidad){
        lista.get(index).setCantidad(cantidad);
    }
    
    public void vaciarCarrito(){
        lista.clear();
    }

    public List<DetallePedido> getLista() {
        return lista;
    }

    public void setLista(List<DetallePedido> lista) {
        this.lista = lista;
    }
    
    
}
