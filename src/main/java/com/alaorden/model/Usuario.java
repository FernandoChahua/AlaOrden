package com.alaorden.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int idUsuario;
    private String apodo;
    private String hashContrasena;
    private String sal;
    private String email;
    private boolean emailValidado;
    private List<Direccion> direcciones;
    private List<Carrito> carrito;

}
