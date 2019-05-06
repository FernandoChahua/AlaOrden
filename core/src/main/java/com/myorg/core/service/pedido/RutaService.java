package com.myorg.core.service.pedido;

import java.awt.Point;
import java.io.Serializable;
import java.math.BigDecimal;

public class RutaService implements Serializable{
    
    BigDecimal precioBase;
    BigDecimal tarifaExtra;

    public RutaService() {
        precioBase = new BigDecimal(10);
        tarifaExtra = new BigDecimal(1);
    }
    
    
    
    public BigDecimal cotizarEnvio(String dest, String orig){
        BigDecimal precioEnv = new BigDecimal(0);
        precioEnv.add(precioBase);
        
        double dist = calcularDistancia(obtenerCoordenada(dest), obtenerCoordenada(orig));
        BigDecimal recargo = new BigDecimal(dist);
        recargo.multiply(tarifaExtra).setScale(2);
        precioEnv.add(recargo);
        return precioEnv;
    }
    
    public double calcularDistancia(double lon_1, double lat_1, double lon_2, double lat_2){
        //TODO implementar
        return 0;
    }
    
    public double calcularDistancia(Point p1, Point p2){
        double lon_1 = p1.getX();
        double lat_1 = p1.getY();
        double lon_2 = p2.getX();
        double lat_2 = p2.getY();
        return calcularDistancia(lon_1, lat_1, lon_2, lat_2);
    }
    
    public Point obtenerCoordenada(String dir){
        //TODO: implementar direccion a coordenada;
        return null;
    }
    
    public double obtenerLongitud(String dir){
        return 0;
    }
    
    public double obtenerLatitud(String dir){
        return 0;
    }
    
}
