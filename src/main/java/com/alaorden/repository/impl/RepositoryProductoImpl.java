package com.alaorden.repository.impl;


import com.alaorden.repository.RepositoryProducto;
import com.alaorden.model.Producto;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.List;

@Component
public class RepositoryProductoImpl implements RepositoryProducto {
    @Override
    public void Delete(Producto entity){

    }
    @Override
    public void Save(Producto entity){

    }
    @Override
    public void Update(Producto entity){

    }
    @Override
    public Producto FindById(Producto entity){
        return null;
    }
    @Override
    public List<Producto> ListAll(){
        return null;
    }
}