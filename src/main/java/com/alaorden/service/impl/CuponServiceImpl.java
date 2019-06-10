package com.alaorden.service.impl;

import com.alaorden.model.Cupon;
import com.alaorden.repository.CuponRepository;
import com.alaorden.service.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuponServiceImpl implements CuponService {
    CuponRepository cuponRepository;

    @Autowired
    public CuponServiceImpl(CuponRepository cuponRepository){
        this.cuponRepository = cuponRepository;
    }
    @Override
    public void Delete(Cupon entity){
        cuponRepository.Delete(entity);
    }
    @Override
    public void Save(Cupon entity){
        cuponRepository.Save(entity);
    }
    @Override
    public void Update(Cupon entity){
        cuponRepository.Update(entity);
    }
    @Override
    public Cupon FindById(Cupon entity){
        return cuponRepository.FindById(entity);
    }
    @Override
    public List<Cupon> ListAll(){
        return cuponRepository.ListAll();
    }

}