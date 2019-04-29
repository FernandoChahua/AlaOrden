package com.myorg.core.repository.impl;

import com.myorg.core.entity.Franquicia;

import com.myorg.core.repository.IFranquiciaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Named
public class FranquiciaRepositoryImpl implements IFranquiciaRepository{

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

    @SuppressWarnings("unchecked")
    @Override
    public Franquicia findById(Franquicia t) throws Exception {
        List<Franquicia> franquicias = new ArrayList<>();
	TypedQuery<Franquicia> query = em.createQuery("Select f FROM Franquicia f WHERE f.id = ?1",Franquicia.class);
	query.setParameter(1, t.getIdFranquicia());

	franquicias = query.getResultList();
        
	return franquicias != null && !franquicias.isEmpty() ? franquicias.get(0) : new Franquicia();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Franquicia> findAll() throws Exception {
        List<Franquicia> franquicias = new ArrayList<>();
	TypedQuery<Franquicia> query = em.createQuery("SELECT f FROM Franquicia f", Franquicia.class);
	franquicias = query.getResultList();
	return franquicias;
    }
    
}
