package com.myorg.core.repository.impl;

import com.myorg.core.entity.Sede;
import com.myorg.core.repository.ISedeRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
public class SedeRepositoryImpl implements Serializable, ISedeRepository  {
    private static final long serialVersionUID = 1L;
	
    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;
    
    @Override
    public boolean insert(Sede t) throws Exception {
        em.persist(t);
        return true;
    }

    @Override
    public boolean update(Sede t) throws Exception {
        em.merge(t);
        return true;
    }

    @Override
    public boolean delete(Sede t) throws Exception {
        em.remove(t);
        return true;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Sede findById(Sede t) throws Exception {
        List<Sede> products = new ArrayList<>();
	Query q = em.createQuery("FROM Sede p where p.id = ?1");
	q.setParameter(1, t.getIdSede());

	products = (List<Sede>) q.getResultList();

	return products != null && !products.isEmpty() ? products.get(0) : new Sede();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Sede> findAll() throws Exception {
        List<Sede> sedes = new ArrayList<>();

	Query q = em.createQuery("SELECT p FROM Sede p");
	sedes = (List<Sede>) q.getResultList();
	return sedes;
    }
    
}
