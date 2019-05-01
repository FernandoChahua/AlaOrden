package com.myorg.web.temp;

//Controller

import com.myorg.core.entity.*;
import com.myorg.core.service.*;
import java.util.List;
import javax.enterprise.context.SessionScoped;

public class CuentaController {
    
    private Usuario sesionActiva;

    //similar a visorCliente, sin lista, valida contraseña
    public boolean registrar(){
        return false;
    }

    //cambia sesion activa luego de validar
    public void iniciarSesion(Usuario c){
        
    }

    //que coincida con la base de datos
    public boolean validarContrasena(Usuario c){
        return false;
    }

    //enviar correo? 
    public void recuperarContrasena(){
        
    }

    //ez
    public void cerrarSesion(){
        
    }

    //update cliente, validacion doble (repetir contraseña)
    public boolean cambiarContrasena(String new1, String new2){
        return false;
    }

    //sesionActiva.pedidos;
    public List<Pedido> getHistorialPedidos(){
        return null;
    }
}
