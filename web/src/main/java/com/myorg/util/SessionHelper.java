package com.myorg.util;

import com.myorg.core.entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

public class SessionHelper {

    public static Object recuperar(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
    }

    public static boolean existe(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey(key);
    }
    
    public static void eliminar(String key) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
    }
    
    public static List<DetallePedido> getCarrito(){
        FacesContext context = FacesContext.getCurrentInstance();
        List<DetallePedido> carrito = (List<DetallePedido>) context.getExternalContext().getSessionMap().get("carrito");
        if (carrito == null){
            carrito = new ArrayList<>();
            context.getExternalContext().getSessionMap().put("pedido", carrito);
        }
        return carrito;
    }
    
    public static Pedido getPedido(){
        FacesContext context = FacesContext.getCurrentInstance();
        Pedido pedido = (Pedido) context.getExternalContext().getSessionMap().get("pedido");
        if (pedido == null){
            pedido = new Pedido();
            context.getExternalContext().getSessionMap().put("pedido", pedido);
        }
        return pedido;
    }
}
