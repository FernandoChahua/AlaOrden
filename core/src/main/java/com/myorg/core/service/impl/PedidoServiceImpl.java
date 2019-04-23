/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.core.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.impl.*;

/**
 *
 * @author nanfo
 */
@Named
public class PedidoServiceImpl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PedidoRepositoryImpl pedidoRepository;

    public void insert(Pedido p) {
        pedidoRepository.insert(p);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
