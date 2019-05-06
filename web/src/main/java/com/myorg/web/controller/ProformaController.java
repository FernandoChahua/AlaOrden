package com.myorg.web.controller;

import com.myorg.core.entity.*;
import com.myorg.core.service.pedido.GeneradorProformas;
import com.myorg.util.SessionHelper;
import com.paypal.api.openidconnect.Session;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ProformaController implements Serializable{
    
    List<DetallePedido> carrito;
    List<DetallePedido> selected;
    Pedido pedido;
    
    @Inject
    private GeneradorProformas generadorProformas;
    
    @PostConstruct
    public void init(){
        pedido = SessionHelper.getPedido();
        carrito = SessionHelper.getCarrito();
        
        //generadorProformas.generarListas(carrito);
        generadorProformas.testMe();
    }
    
    public List<Map.Entry<String,List<DetallePedido>>> getProformas(){
        Map<String,List<DetallePedido>> map =generadorProformas.getProformas();
        Set<Map.Entry<String,List<DetallePedido>>> set = map.entrySet();
        return new ArrayList<>(set);
    }    

    public List<DetallePedido> buscarProforma(String franquicia){
        return generadorProformas.buscarProforma(franquicia);
    }
    
    public BigDecimal subtotalProforma(String franquicia){
        return generadorProformas.subtotalPorFranquicia(franquicia);
    }
    
    public void elegirProforma(String franquicia){
        selected = generadorProformas.buscarProforma(franquicia);
        Pedido pedido = SessionHelper.getPedido();
        pedido.setDetalles(selected);
        pedido.setSubtotal(subtotalProforma(franquicia));
    }
}
