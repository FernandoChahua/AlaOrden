package com.myorg.core.repository.impl;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.util.Conexion;
import com.myorg.core.repository.ICategoriaRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Named
public class CategoriaRepositoryImpl implements Serializable, ICategoriaRepository {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;
    
    @Override
    public boolean insert(Categoria t) throws Exception {
        boolean rpta = false;
            try{
                em.persist(t);
                rpta = true;
            }catch(Exception ex){
                throw ex;
            }
            return rpta;
    }

    @Override
    public boolean update(Categoria t) throws Exception {
        boolean rpta = false;
            try{
                em.merge(t);
            }catch(Exception ex){
                throw ex;
            }
            return rpta;
    }

    @Override
    public boolean delete(Categoria t) throws Exception {
        boolean rpta = false;
            try{
                em.remove(t);
            }catch(Exception ex){
                throw ex;
            }
            return rpta;
    }

    @Override
    public Categoria findById(Categoria t) throws Exception {
        List<Categoria> categorias = new ArrayList<>();
            TypedQuery<Categoria> categoriaExists = null;
            try{
                Query q = em.createQuery("FROM producto p where p.idProducto = ?1");
                q.setParameter(1, t.getIdCategoria());
            }catch(Exception ex){
                categorias = new ArrayList<>();
            }
            categorias = categoriaExists.getResultList();
            return categorias != null && !categorias.isEmpty() ? categorias.get(0) : new Categoria();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Categoria> findAll() throws Exception {
        List<Categoria> categorias = new ArrayList<>();
            TypedQuery<Categoria> categoriaExists = null;
            try{
                Query q = em.createQuery("SELECT p FROM producto p");
            }catch(Exception ex){
                categorias = new ArrayList<>();
            }
                categorias = categoriaExists.getResultList();
            return categorias;
    }
    
}
