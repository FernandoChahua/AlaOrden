package com.myorg.core.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.repository.ICategoriaRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named
public class CategoriaRepositoryImpl implements ICategoriaRepository {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;
    
    @Override
    public boolean insert(Categoria c) throws Exception {
        boolean rpta = false;
            try{
                em.persist(c);
                rpta = true;
            }catch(Exception ex){
                throw ex;
            }
            return rpta;
    }

    @Override
    public boolean update(Categoria c) throws Exception {
        boolean rpta = false;
            try{
                em.merge(c);
            }catch(Exception ex){
                throw ex;
            }
            return rpta;
    }

    @Override
    public boolean delete(Categoria c) throws Exception {
        boolean rpta = false;
            try{
                em.remove(c);
            }catch(Exception ex){
                throw ex;
            }
            return rpta;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Categoria> findAll() throws Exception {
        List<Categoria> categorias = new ArrayList<>();
            TypedQuery<Categoria> categoriaExists = null;
            try{
                categoriaExists = em.createQuery("SELECT c FROM Categoria c", Categoria.class);
            }catch(Exception ex){
                categorias = new ArrayList<>();
            }
            categorias = categoriaExists.getResultList();
            return categorias;
    }

    @Override
    public Categoria findById(Categoria c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria findByName(Categoria c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
