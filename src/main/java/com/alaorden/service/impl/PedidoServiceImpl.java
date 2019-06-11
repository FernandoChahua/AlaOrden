package com.alaorden.service.impl;

import com.alaorden.model.Pedido;
import com.alaorden.repository.PedidoRepository;
import com.alaorden.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    
}
