package com.myorg.core.service.payment;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;

//Entidad que se encarga de procesar el pago
public class Gateway {

    public synchronized Respuesta autorizar(Map<String, String> paramValidacion) throws Exception {
        wait(2000);
        //TODO: editar contenido rpta
        Respuesta rpta = new Respuesta();
        if (Integer.parseInt(paramValidacion.get("ccv")) % 2 == 0) {
            rpta.setMensaje("Error al validar Tarjeta");
            rpta.setSatisfactoria(false);

        } else {
            rpta.setMensaje("Tarjeta validada satisfactoriamente");
            rpta.setSatisfactoria(true);

        }
        return rpta;
    }

    public synchronized Respuesta pagar(Map<String, String> paramPago) throws Exception {
        Respuesta rpta = autorizar(paramPago);

        if (!rpta.isSatisfactoria()) {
            return rpta;
        }
        //TODO: editar contenido rpta
        wait(3000);
        //genera nroTransaccion
        Random r = new Random();
        Integer nroTrans = r.nextInt(900000000) + 100000000;
        rpta.setNroTransacion(nroTrans);
        rpta.setMensaje("Tranasccion realizada con exito");
        return rpta;
    }

    public Respuesta reembolsar(Map<String, String> paraRembolso) throws Exception {
        return null;
    }
}
