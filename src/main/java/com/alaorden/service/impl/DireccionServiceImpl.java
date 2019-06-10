package com.alaorden.service.impl;

import com.alaorden.model.Direccion;
import com.alaorden.model.Usuario;
import com.alaorden.repository.DireccionRepository;
import com.alaorden.repository.UsuarioRepository;
import com.alaorden.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DireccionServiceImpl implements DireccionService {

    DireccionRepository direccionRepository;
    UsuarioRepository usuarioRepository;
    @Autowired
    public DireccionServiceImpl(DireccionRepository direccionRepository){
        this.direccionRepository = direccionRepository;
    }

    public Direccion createDireccion(Direccion direccion){
        return direccionRepository.save(direccion);
    }

    public Direccion deleteDireccion(int id){
        Direccion direccion = direccionRepository.findById(id).get();
        if(direccion == null){
            return null;
        }else{
            direccionRepository.delete(direccion);
            return direccion;
        }
    }
    public List<Direccion> listDireccionByUsuario(int id){
        Usuario usuario = usuarioRepository.findById(id).get();
        return direccionRepository.findAllByUsuario(usuario);
    }

    

}
