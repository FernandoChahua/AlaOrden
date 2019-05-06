package com.myorg.core.service.payment;

import java.io.Serializable;
import java.util.Map;

public class Respuesta implements Serializable{
    private boolean satisfactoria;
    private Integer nroTransacion;
    private String mensaje;
    
    private Map<String,String> contenido;

    public boolean isSatisfactoria() {
        return satisfactoria;
    }

    public void setSatisfactoria(boolean satisfactoria) {
        this.satisfactoria = satisfactoria;
    }

    public Integer getNroTransacion() {
        return nroTransacion;
    }

    public void setNroTransacion(Integer nroTransacion) {
        this.nroTransacion = nroTransacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Map<String, String> getContenido() {
        return contenido;
    }

    public void setContenido(Map<String, String> contenido) {
        this.contenido = contenido;
    }
    
    
    
}
