package com.alaorden.repository.impl;


import com.alaorden.repository.MarcaRepository;
import com.alaorden.model.Marca;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class MarcaRepositoryImpl implements MarcaRepository {
    @Override
    public void Delete(Marca entity){

    }
    @Override
    public void Save(Marca entity){

    }
    @Override
    public void Update(Marca entity){

    }
    @Override
    public Marca FindById(Marca entity){
        return null;
    }
    @Override
    public List<Marca> ListAll(){
        return null;
    }
}