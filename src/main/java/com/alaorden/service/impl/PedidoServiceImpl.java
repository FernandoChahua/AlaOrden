package com.alaorden.service.impl;

import com.alaorden.model.Pedido;
import com.alaorden.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidoService pedidoService;

    @Autowired
    public PedidoServiceImpl(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    



}
