package com.myorg.core.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.myorg.core.entity.Pedido;
//import com.myorg.core.entity.DetallePedido;
import com.myorg.core.repository.IPedidoRepository;

@Named
public class PedidoRepositoryImpl implements IPedidoRepository {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;

    @Override
    public boolean insert(Pedido p) {
        em.persist(p);
        return true;
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> pedidos = new ArrayList<>();
        TypedQuery<Pedido> pedidoExists = null;
        try {
            pedidoExists = em.createQuery("Select p from Pedido p", Pedido.class);
        } catch (Exception e) {
            pedidos = new ArrayList<>();
        }
        pedidos = pedidoExists.getResultList();
        return pedidos;
    }

    @Override
    public boolean update(Pedido t) throws Exception {
        em.merge(t);
        return true;
    }

    @Override
    public boolean delete(Pedido t) throws Exception {
        em.remove(t);
        return false;
    }

    @Override
    public Pedido findById(Pedido t) throws Exception {
        return null;
    }

}
