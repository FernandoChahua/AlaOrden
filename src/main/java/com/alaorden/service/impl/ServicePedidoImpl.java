package com.alaorden.service.impl;

import com.alaorden.model.Pedido;
import com.alaorden.repository.RepositoryPedido;
import com.alaorden.service.ServicePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePedidoImpl implements ServicePedido {
    RepositoryPedido repositoryPedido;

    @Autowired
    public ServicePedidoImpl(RepositoryPedido repositoryPedido){
        this.repositoryPedido = repositoryPedido;
    }
    @Override
    public void Delete(Pedido entity){
        repositoryPedido.Delete(entity);
    }
    @Override
    public void Save(Pedido entity){
        repositoryPedido.Save(entity);
    }
    @Override
    public void Update(Pedido entity){
        repositoryPedido.Update(entity);
    }
    @Override
    public Pedido FindById(Pedido entity){
        return repositoryPedido.FindById(entity);
    }
    @Override
    public List<Pedido> ListAll(){
        return repositoryPedido.ListAll();
    }

}