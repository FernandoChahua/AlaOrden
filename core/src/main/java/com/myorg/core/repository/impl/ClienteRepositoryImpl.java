package com.myorg.core.repository.impl;

import java.util.List;

import com.myorg.core.entity.*;
import com.myorg.core.repository.IClienteRepository;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.persistence.*;

@Named
public class ClienteRepositoryImpl implements IClienteRepository, Serializable {

    @PersistenceContext(unitName = "VisorPU")
    private EntityManager em;

    @Override
    public boolean insert(Cliente c) throws Exception {
        boolean rpta = false;
        try {
            em.persist(c);
            rpta = true;
        } catch (Exception ex) {
            throw ex;
        }
        return rpta;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> findAll() throws Exception {
        List<Cliente> list = new ArrayList<>();

        try {
            Query q = em.createQuery("SELECT c FROM Cliente c");
            list = (List<Cliente>) q.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public boolean update(Cliente c) throws Exception {
        boolean rpta = false;
        try {
            em.merge(c);
            rpta = true;
        } catch (Exception ex) {
            throw ex;
        }
        return rpta;
    }

    @Override
    public boolean delete(Cliente c) throws Exception {
        boolean rpta = false;
        try {
            em.persist(c);
            rpta = true;
        } catch (Exception ex) {
            throw ex;
        }
        return rpta;
    }

    @Override
    public Cliente findById(Cliente c) throws Exception {
        List<Cliente> list = new ArrayList<>();

        try {
            Query q = em.createQuery("SELECT c FROM Cliente c WHERE c.idCliente = ?1");
            q.setParameter(1, c.getIdCliente());
            list = (List<Cliente>) q.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return (list != null && !list.isEmpty() )? list.get(0) : new Cliente() ;
    }

}
