package com.alaorden.service.impl;

import com.alaorden.model.DetallePedido;
import com.alaorden.repository.DetallePedidoRepository;
import com.alaorden.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
    DetallePedidoRepository detallePedidoRepository;

    @Autowired
    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository){
        this.detallePedidoRepository = detallePedidoRepository;
    }
    @Override
    public void Delete(DetallePedido entity){
        detallePedidoRepository.Delete(entity);
    }
    @Override
    public void Save(DetallePedido entity){
        detallePedidoRepository.Save(entity);
    }
    @Override
    public void Update(DetallePedido entity){
        detallePedidoRepository.Update(entity);
    }
    @Override
    public DetallePedido FindById(DetallePedido entity){
        return detallePedidoRepository.FindById(entity);
    }
    @Override
    public List<DetallePedido> ListAll(){
        return detallePedidoRepository.ListAll();
    }

}