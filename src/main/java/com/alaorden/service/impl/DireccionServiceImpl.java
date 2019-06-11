package com.alaorden.service.impl;

import com.alaorden.model.Direccion;
import com.alaorden.model.Sede;
import com.alaorden.model.Usuario;
import com.alaorden.repository.DireccionRepository;
import com.alaorden.repository.SedeRepository;
import com.alaorden.repository.UsuarioRepository;
import com.alaorden.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class DireccionServiceImpl implements DireccionService {


    DireccionRepository direccionRepository;
    UsuarioRepository usuarioRepository;
    SedeRepository sedeRepository;
    @Autowired
    public DireccionServiceImpl(DireccionRepository direccionRepository,UsuarioRepository usuarioRepository,SedeRepository sedeRepository){
        this.direccionRepository = direccionRepository;
        this.usuarioRepository = usuarioRepository;
        this.sedeRepository = sedeRepository;
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
    public BigDecimal calculaPrecioEnvio(double distancia){
        return BigDecimal.valueOf(distancia*0.05 + 5.00);
    }

    public double calculaDistancia(double latA,double longA,double latB,double longB){
        /*var R = 6371; // Radius of the earth in km
        var dLat = deg2rad(lat2-lat1);  // deg2rad below
        var dLon = deg2rad(lon2-lon1);
        var a =
                Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon/2) * Math.sin(dLon/2)
                ;
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        var d = R * c; // Distance in km
        return d;*/

        double R = 6137;
        double dLat = Math.toRadians(latB-latA);
        double dLong = Math.toRadians(longB-longA);
        double a = Math.sin(dLat/2)*Math.sin(dLat/2)+Math.cos(Math.toRadians(latA))*Math.cos(Math.toRadians(latB))*Math.sin(dLong/2)*Math.sin(dLong/2);
        double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        double d = R*c;
        return d;
    }

    public boolean Existe(String s,List<String>ls){
        for(String franquicia : ls){
            if(s == franquicia)return true;
        }
        return false;
    }
    public List<Sede> listDistanciaMin(double latitud,double longitud){
        List<Sede> sedes = sedeRepository.findAll();
        List<String>setSedes = new ArrayList<>();

        List<Sede> sedesEscogidas = new ArrayList<>();

        for(Sede sede : sedes){
            double dist = calculaDistancia(latitud,longitud,sede.getLatitud().doubleValue(),sede.getLogngitud().doubleValue());
            if(dist <= 3.500)
            {
                if(!Existe(sede.getFranquicia().getNombre(),setSedes)){
                    sedesEscogidas.add(sede);
                    setSedes.add(sede.getFranquicia().getNombre());
                }
            }
        }
        return sedesEscogidas;
    }




}
