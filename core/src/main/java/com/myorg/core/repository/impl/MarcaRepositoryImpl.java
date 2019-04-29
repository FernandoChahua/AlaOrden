package com.myorg.core.repository.impl;

import com.myorg.core.entity.Marca;
import com.myorg.core.repository.IMarcaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named
public class MarcaRepositoryImpl implements IMarcaRepository {
    
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;
    
    @Override
    public boolean insert(Marca m) throws Exception {
        em.persist(m);
        return true;
    }

    @Override
    public boolean update(Marca m) throws Exception {
        em.merge(m);
        return true;
    }

    @Override
    public boolean delete(Marca m) throws Exception {
        em.remove(m);
        return true;
    }

    @Override
    public Marca findById(Marca t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Marca> findAll() throws Exception {
        List<Marca> list = new ArrayList<>();
        TypedQuery<Marca> query = em.createQuery("SELECT m FROM Marca m", Marca.class);
        list = query.getResultList();
        return list;
    }

    @Override
    public Marca findByName(Marca m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
