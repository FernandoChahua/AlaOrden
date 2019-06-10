package com.alaorden.service.impl;

import com.alaorden.model.Sede;
import com.alaorden.repository.SedeRepository;
import com.alaorden.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImpl implements SedeService {
    SedeRepository sedeRepository;

    @Autowired
    public SedeServiceImpl(SedeRepository sedeRepository){
        this.sedeRepository = sedeRepository;
    }
    @Override
    public void Delete(Sede entity){
        sedeRepository.Delete(entity);
    }
    @Override
    public void Save(Sede entity){
        sedeRepository.Save(entity);
    }
    @Override
    public void Update(Sede entity){
        sedeRepository.Update(entity);
    }
    @Override
    public Sede FindById(Sede entity){
        return sedeRepository.FindById(entity);
    }
    @Override
    public List<Sede> ListAll(){
        return sedeRepository.ListAll();
    }

}