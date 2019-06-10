package com.alaorden.repository.impl;


import com.alaorden.repository.PedidoRepository;
import com.alaorden.model.Pedido;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class PedidoRepositoryImpl implements PedidoRepository {
    @Override
    public void Delete(Pedido entity){

    }
    @Override
    public void Save(Pedido entity){

    }
    @Override
    public void Update(Pedido entity){

    }
    @Override
    public Pedido FindById(Pedido entity){
        return null;
    }
    @Override
    public List<Pedido> ListAll(){
        return null;
    }
}