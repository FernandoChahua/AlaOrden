package com.myorg.core.repository.impl;

import com.myorg.core.entity.ProductoFranquicia;
import com.myorg.core.repository.IProductoFranquiciaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Deprecated
public class ProductoFranquiciaRepositoryImpl implements IProductoFranquiciaRepository {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext(unitName = "visorPU")
    EntityManager em;

    @Override
    public boolean insert(ProductoFranquicia pf) throws Exception {
        em.persist(pf);
        return true;
    }

    @Override
    public boolean update(ProductoFranquicia pf) throws Exception {
        em.merge(pf);
        return true;
    }

    @Override
    public boolean delete(ProductoFranquicia pf) throws Exception {
        em.remove(pf);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ProductoFranquicia findById(ProductoFranquicia pf) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProductoFranquicia> findAll() throws Exception {
        List<ProductoFranquicia> list = new ArrayList<>();
        TypedQuery<ProductoFranquicia> query = em.createQuery("SELECT pf FROM ProductoFranquicia pf", ProductoFranquicia.class);
        list = query.getResultList();
        return list;
    }

}
