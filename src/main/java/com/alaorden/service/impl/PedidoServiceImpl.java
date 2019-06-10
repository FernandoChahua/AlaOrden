package com.alaorden.service.impl;

import com.alaorden.model.Pedido;
import com.alaorden.repository.PedidoRepository;
import com.alaorden.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }
    @Override
    public void Delete(Pedido entity){
        pedidoRepository.Delete(entity);
    }
    @Override
    public void Save(Pedido entity){
        pedidoRepository.Save(entity);
    }
    @Override
    public void Update(Pedido entity){
        pedidoRepository.Update(entity);
    }
    @Override
    public Pedido FindById(Pedido entity){
        return pedidoRepository.FindById(entity);
    }
    @Override
    public List<Pedido> ListAll(){
        return pedidoRepository.ListAll();
    }

}