/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.core.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.Pedido;
import com.myorg.core.repository.PedidoRepository;

/**
 *
 * @author nanfo
 */
@Named
public class PedidoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PedidoRepository pedidoRepository;

    public void savePedido(Pedido p) {
        pedidoRepository.save(p);
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }
}
