package com.myorg.core.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.IPedidoRepository;
import com.myorg.core.service.IPedidoService;
import javax.transaction.Transactional;

@Named
public class PedidoServiceImpl implements IPedidoService {

    private static final long serialVersionUID = 1L;

    @Inject
    private IPedidoRepository pedidoRepository;

    @Transactional
    @Override
    public boolean insert(Pedido p) throws Exception {
        return pedidoRepository.insert(p);
    }

    @Override
    public List<Pedido> findAll() throws Exception {
        return pedidoRepository.findAll();
    }

    @Transactional
    @Override
    public boolean update(Pedido p) throws Exception {
        return pedidoRepository.update(p);
    }

    @Transactional
    @Override
    public boolean delete(Pedido p) throws Exception {
        return pedidoRepository.delete(p);
    }

    @Override
    public Pedido findById(Pedido p) throws Exception {
        return pedidoRepository.findById(p);
    }
}
