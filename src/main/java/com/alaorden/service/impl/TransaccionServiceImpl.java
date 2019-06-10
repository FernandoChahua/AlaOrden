package com.alaorden.service.impl;

import com.alaorden.model.Transaccion;
import com.alaorden.repository.TransaccionRepository;
import com.alaorden.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionServiceImpl implements TransaccionService {
    TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionServiceImpl(TransaccionRepository transaccionRepository){
        this.transaccionRepository = transaccionRepository;
    }
    @Override
    public void Delete(Transaccion entity){
        transaccionRepository.Delete(entity);
    }
    @Override
    public void Save(Transaccion entity){
        transaccionRepository.Save(entity);
    }
    @Override
    public void Update(Transaccion entity){
        transaccionRepository.Update(entity);
    }
    @Override
    public Transaccion FindById(Transaccion entity){
        return transaccionRepository.FindById(entity);
    }
    @Override
    public List<Transaccion> ListAll(){
        return transaccionRepository.ListAll();
    }

}