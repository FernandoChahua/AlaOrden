package com.alaorden.repository.impl;

import com.alaorden.repository.CarritoItemRepository;
import com.alaorden.model.CarritoItem;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class CarritoItemRepositoryImpl implements CarritoItemRepository {
    @Override
    public void Delete(CarritoItem entity){

    }
    @Override
    public void Save(CarritoItem entity){

    }
    @Override
    public void Update(CarritoItem entity){

    }
    @Override
    public CarritoItem FindById(CarritoItem entity){
        return null;
    }
    @Override
    public List<CarritoItem> ListAll(){
        return null;
    }
}
