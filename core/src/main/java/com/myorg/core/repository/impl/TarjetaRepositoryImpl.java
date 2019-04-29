package com.myorg.core.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.myorg.core.entity.Tarjeta;

import com.myorg.core.repository.ITarjetaRepository;

@Named
public class TarjetaRepositoryImpl implements ITarjetaRepository {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;

    @Override
    public boolean insert(Tarjeta t) throws Exception {
        em.persist(t);
        return true;
    }

    @Override
    public List<Tarjeta> findAll() throws Exception {
        List<Tarjeta> tarjetas = new ArrayList<>();

        TypedQuery<Tarjeta> tarjetaExists = null;

        try {
            tarjetaExists = em.createQuery("Select t from Tarjeta t", Tarjeta.class);
            tarjetas = tarjetaExists.getResultList();

        } catch (Exception e) {
            tarjetas = new ArrayList<>();
        }

        return tarjetas;
    }

    @Override
    public boolean update(Tarjeta t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Tarjeta t) throws Exception {
        return false;
    }

    @Override
    public Tarjeta findById(Tarjeta id) throws Exception {
        return null;
    }

}
