package com.alaorden.repository.impl;


import com.alaorden.repository.TransaccionRepository;
import com.alaorden.model.Transaccion;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class TransaccionRepositoryImpl implements TransaccionRepository {
    @Override
    public void Delete(Transaccion entity){

    }
    @Override
    public void Save(Transaccion entity){

    }
    @Override
    public void Update(Transaccion entity){

    }
    @Override
    public Transaccion FindById(Transaccion entity){
        return null;
    }
    @Override
    public List<Transaccion> ListAll(){
        return null;
    }
}