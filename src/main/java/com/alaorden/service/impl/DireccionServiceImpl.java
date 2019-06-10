package com.alaorden.service.impl;

import com.alaorden.model.Direccion;
import com.alaorden.repository.DireccionRepository;
import com.alaorden.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {
    DireccionRepository direccionRepository;

    @Autowired
    public DireccionServiceImpl(DireccionRepository direccionRepository){
        this.direccionRepository = direccionRepository;
    }
    @Override
    public void Delete(Direccion entity){
        direccionRepository.Delete(entity);
    }
    @Override
    public void Save(Direccion entity){
        direccionRepository.Save(entity);
    }
    @Override
    public void Update(Direccion entity){
        direccionRepository.Update(entity);
    }
    @Override
    public Direccion FindById(Direccion entity){
        return direccionRepository.FindById(entity);
    }
    @Override
    public List<Direccion> ListAll(){
        return direccionRepository.ListAll();
    }

}