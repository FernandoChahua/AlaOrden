package com.alaorden.service.impl;

import com.alaorden.model.CarritoItem;
import com.alaorden.repository.CarritoItemRepository;
import com.alaorden.service.CarritoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoItemServiceImpl implements CarritoItemService {
    CarritoItemRepository carritoItemRepository;

    @Autowired
    public CarritoItemServiceImpl(CarritoItemRepository carritoItemRepository){
        this.carritoItemRepository = carritoItemRepository;
    }
    @Override
    public void Delete(CarritoItem entity){
        carritoItemRepository.Delete(entity);
    }
    @Override
    public void Save(CarritoItem entity){
        carritoItemRepository.Save(entity);
    }
    @Override
    public void Update(CarritoItem entity){
        carritoItemRepository.Update(entity);
    }
    @Override
    public CarritoItem FindById(CarritoItem entity){
        return carritoItemRepository.FindById(entity);
    }
    @Override
    public List<CarritoItem> ListAll(){
        return carritoItemRepository.ListAll();
    }

}