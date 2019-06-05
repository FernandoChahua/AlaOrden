package com.alaorden.service.impl;

import com.alaorden.model.DetallePedido;
import com.alaorden.repository.RepositoryDetallePedido;
import com.alaorden.service.ServiceDetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDetallePedidoImpl implements ServiceDetallePedido {
    RepositoryDetallePedido repositoryDetallePedido;

    @Autowired
    public ServiceDetallePedidoImpl(RepositoryDetallePedido repositoryDetallePedido){
        this.repositoryDetallePedido = repositoryDetallePedido;
    }
    @Override
    public void Delete(DetallePedido entity){
        repositoryDetallePedido.Delete(entity);
    }
    @Override
    public void Save(DetallePedido entity){
        repositoryDetallePedido.Save(entity);
    }
    @Override
    public void Update(DetallePedido entity){
        repositoryDetallePedido.Update(entity);
    }
    @Override
    public DetallePedido FindById(DetallePedido entity){
        return repositoryDetallePedido.FindById(entity);
    }
    @Override
    public List<DetallePedido> ListAll(){
        return repositoryDetallePedido.ListAll();
    }

}