package com.alaorden.service.impl;

import com.alaorden.model.Marca;
import com.alaorden.repository.MarcaRepository;
import com.alaorden.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {
    MarcaRepository marcaRepository;

    @Autowired
    public MarcaServiceImpl(MarcaRepository marcaRepository){
        this.marcaRepository = marcaRepository;
    }
    @Override
    public void Delete(Marca entity){
        marcaRepository.Delete(entity);
    }
    @Override
    public void Save(Marca entity){
        marcaRepository.Save(entity);
    }
    @Override
    public void Update(Marca entity){
        marcaRepository.Update(entity);
    }
    @Override
    public Marca FindById(Marca entity){
        return marcaRepository.FindById(entity);
    }
    @Override
    public List<Marca> ListAll(){
        return marcaRepository.ListAll();
    }

}