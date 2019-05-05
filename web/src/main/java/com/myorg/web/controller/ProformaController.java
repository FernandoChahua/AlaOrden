package com.myorg.web.controller;

import com.myorg.core.entity.*;
import com.myorg.core.service.pedido.GeneradorProformas;
import com.myorg.util.SessionHelper;
import com.myorg.core.service.pedido.Proforma;
import java.io.Serializable;
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
    Pedido pedido;
    
    @Inject
    private GeneradorProformas generadorProformas;
    
    @PostConstruct
    public void init(){
        pedido = SessionHelper.getPedido();
        carrito = SessionHelper.getCarrito();
    }
    
//    public List<Map.Entry<String,List<DetallePedido>>> getProformas(){
//        Map<String,List<DetallePedido>> map =generadorProformas.getProformas();
//        Set<Map.Entry<String,List<DetallePedido>>> set = map.entrySet();
//        return new ArrayList<>(set);
//    }    
    public List<Proforma> getProformas(){
        return new ArrayList<>(generadorProformas.getProformas().values());
    }
}
