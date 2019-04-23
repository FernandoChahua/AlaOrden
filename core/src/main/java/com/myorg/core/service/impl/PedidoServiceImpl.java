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
import com.myorg.core.service.IPedidoService;
import javax.transaction.Transactional;

/**
 *
 * @author nanfo
 */
@Named
public class PedidoServiceImpl implements Serializable, IPedidoService {

    private static final long serialVersionUID = 1L;

    @Inject
    private PedidoRepositoryImpl pedidoRepository;

    @Transactional
    @Override
    public boolean insert(Pedido p) {
        return pedidoRepository.insert(p);
    }

    @Transactional
    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Transactional
    @Override
    public boolean update(Pedido t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public boolean delete(Pedido t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public Pedido findById(Pedido t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
