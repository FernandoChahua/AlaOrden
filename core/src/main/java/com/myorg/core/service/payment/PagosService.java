package com.myorg.core.service.payment;

import com.myorg.core.entity.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PagosService implements Serializable {

    private String user = "user";
    private String key = "$dsa#457df8484f$#%3";
  
    @Inject
    private Gateway gateway;

    public boolean validar(Tarjeta tarjeta, InfoPago infoPago, BigDecimal monto) {
        Map<String, String> paramTransaccion = new HashMap<>();
        try {
            paramTransaccion = GatewayHelper.armarParametroVenta(user, key ,tarjeta, infoPago, monto);
            Respuesta rpta = gateway.autorizar(paramTransaccion);
            return rpta.isSatisfactoria();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validar(Map<String, String> paramValidacion) {
        try {
            Respuesta rpta = gateway.autorizar(paramValidacion);
            return rpta.isSatisfactoria();
        } catch (Exception e) {
            return false;
        }
    }

    public Integer pagar(Tarjeta tarjeta, InfoPago infoPago, BigDecimal monto) {
        Map<String, String> paramTransaccion = new HashMap<>();
        Respuesta rpta = null;
        try {
            paramTransaccion = GatewayHelper.armarParametroVenta(user,key,tarjeta, infoPago, monto);
            rpta = gateway.pagar(paramTransaccion);

        } catch (Exception e) {

        }
        return rpta.getNroTransacion();
    }

    public Integer pagar(Map<String, String> paramTransaccion) {
        Respuesta rpta = null;
        try {
            rpta = gateway.pagar(paramTransaccion);

        } catch (Exception e) {

        }
        return rpta.getNroTransacion();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
