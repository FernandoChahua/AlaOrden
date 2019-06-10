package com.alaorden.service.impl;

import com.alaorden.model.Franquicia;
import com.alaorden.repository.FranquiciaRepository;
import com.alaorden.service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranquiciaServiceImpl implements FranquiciaService {
    FranquiciaRepository franquiciaRepository;

    @Autowired
    public FranquiciaServiceImpl(FranquiciaRepository franquiciaRepository){
        this.franquiciaRepository = franquiciaRepository;
    }
    @Override
    public void Delete(Franquicia entity){
        franquiciaRepository.Delete(entity);
    }
    @Override
    public void Save(Franquicia entity){
        franquiciaRepository.Save(entity);
    }
    @Override
    public void Update(Franquicia entity){
        franquiciaRepository.Update(entity);
    }
    @Override
    public Franquicia FindById(Franquicia entity){
        return franquiciaRepository.FindById(entity);
    }
    @Override
    public List<Franquicia> ListAll(){
        return franquiciaRepository.ListAll();
    }

}