package com.alaorden.service;

import com.alaorden.model.Direccion;
import com.alaorden.model.Usuario;

import java.util.List;

public interface DireccionService {

    Direccion createDireccion(Direccion direccion);
    Direccion deleteDireccion(int id);
    List<Direccion> listDireccionByUsuario(int id);

}
