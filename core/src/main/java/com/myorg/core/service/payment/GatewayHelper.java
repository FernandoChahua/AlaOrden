package com.myorg.core.service.payment;

import com.myorg.core.entity.Tarjeta;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GatewayHelper {

        public static Map<String, String> armarParametroVenta(String user, String key, Tarjeta tarjeta, InfoPago info, BigDecimal monto) {
        Map<String, String> paramTransaccion = new HashMap<>();

        //FIXME: La info en usuario no nos sirve xd
        paramTransaccion.put("tipo", "venta");
        paramTransaccion.put("user", user);
        paramTransaccion.put("password", key);
        paramTransaccion.put("pan", tarjeta.getNroCuenta());
        paramTransaccion.put("mes_expiracion", Integer.toString(tarjeta.getFechaExp().getMonthValue()));
        paramTransaccion.put("año_expiracion", Integer.toString(tarjeta.getFechaExp().getYear()));
        paramTransaccion.put("ccv", info.getCcv());
        paramTransaccion.put("monto", monto.toString());
        paramTransaccion.put("moneda", "PEN");
        paramTransaccion.put("fecha", LocalDateTime.now().toString());
        paramTransaccion.put("nombre", info.getNombre());
        paramTransaccion.put("apellido", info.getApellido());
        //TODO: incluir direccion
        return paramTransaccion;
    }
}
