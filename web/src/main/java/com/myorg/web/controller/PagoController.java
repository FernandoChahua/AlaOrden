package com.myorg.web.controller;

import com.myorg.core.entity.*;
import com.myorg.core.service.ITarjetaService;
import com.myorg.core.service.payment.InfoPago;
import com.myorg.core.service.payment.PagosService;
import com.myorg.util.SessionHelper;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PagoController implements Serializable {

    @Inject
    private ITarjetaService tarjetaService;
    
    @Inject
    private PagosService pagosService;
    
    private List<Tarjeta> tarjetas;
    private Tarjeta tarjeta;
    private InfoPago infoPago;

    @PostConstruct
    public void init() {
        this.tarjeta = new Tarjeta();
        this.infoPago = new InfoPago();
        loadTarjetas();
    }

    public void loadTarjetas() {
        try {
            Usuario usuario = SessionHelper.getUsuario();
            Tarjeta t = new Tarjeta();
            t.setUsuario(usuario);
            tarjetas = tarjetaService.findAllByUsuario(usuario.getIdUsuario());
        } catch (Exception e) {
            tarjetas = new ArrayList<>();
        }
    }
    
    public void procesar() {
        if (tarjeta.getIdTarjeta() == null){
            tarjeta.setTitular(infoPago.getNombre() + " " + infoPago.getApellido());
            tarjeta.setUsuario(SessionHelper.getUsuario());
            try{
                tarjetaService.insert(tarjeta);
            } catch (Exception e){
                SessionHelper.redirect("./Error.xhtml");
                return;
            }
            
        }
        Pedido pedido = SessionHelper.getPedido();
        
        BigDecimal total = new BigDecimal(0);
        total = total.add(pedido.getSubtotal());
        total = total.add(pedido.getPrecioEnvio());
        total = total.subtract(pedido.getDescuento());
        
        pagosService.pagar(tarjeta, infoPago, total);
        
        SessionHelper.redirect("./VerRecibo.xhtml");
    }
    
    public void clean(){
        tarjeta = new Tarjeta();
        infoPago = new InfoPago();
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public InfoPago getInfoPago() {
        return infoPago;
    }

    public void setInfoPago(InfoPago infoPago) {
        this.infoPago = infoPago;
    }
   
}
