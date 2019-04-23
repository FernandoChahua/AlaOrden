package com.myorg.core.repository.impl;

import com.myorg.core.entity.Franquicia;

import com.myorg.core.repository.IFranquiciaRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class FranquiciaRepositoryImpl implements Serializable,IFranquiciaRepository{

    private static final long serialVersionUID = 1L;
	
    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;
    
    @Override
    public boolean insert(Franquicia t) throws Exception {
        em.persist(t);
        return true;
    }

    @Override
    public boolean update(Franquicia t) throws Exception {
        em.merge(t);
        return true;
    }

    @Override
    public boolean delete(Franquicia t) throws Exception {
        em.remove(t);
        return true;
    }

    @Override
    public Franquicia findById(Franquicia t) throws Exception {
        List<Franquicia> franquicias = new ArrayList<>();
	Query q = em.createQuery("FROM Sede p where p.id = ?1");
	q.setParameter(1, t.getIdFranquicia());

	franquicias = (List<Franquicia>) q.getResultList();

	return franquicias != null && !franquicias.isEmpty() ? franquicias.get(0) : new Franquicia();
    }

    @Override
    public List<Franquicia> findAll() throws Exception {
        List<Franquicia> franquicias = new ArrayList<>();

	Query q = em.createQuery("SELECT p FROM Franquicia p");
	franquicias = (List<Franquicia>) q.getResultList();
	return franquicias;
    }
    
}
