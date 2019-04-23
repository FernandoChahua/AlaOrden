package com.myorg.core.repository.impl;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.myorg.core.entity.*;
import com.myorg.core.util.Conexion;
import com.myorg.core.repository.IProductoRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
public class ProductoRepositoryImpl implements Serializable, IProductoRepository {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;
    
    @Override
    public boolean insert(Producto p)throws Exception  {
            em.persist(p);
            return true;
    }
    
    @Override
    public boolean update(Producto p) throws Exception {
            em.merge(p);
            return true;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Producto> findAll() throws Exception {
            List<Producto> productos = new ArrayList<>();
            Query q = em.createQuery("SELECT p FROM producto p");
            productos = (List<Producto>) q.getResultList();
            return productos;
    }

    @Override
    public boolean delete(Producto p) throws Exception {
            em.remove(p);
            return true;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Producto findById(Producto p) throws Exception {
            List<Producto> productos = new ArrayList<>();
            Query q = em.createQuery("FROM producto p where p.idProducto = ?1");
            q.setParameter(1, p.getIdProducto());

            productos = (List<Producto>) q.getResultList();

            return productos != null && !productos.isEmpty() ? productos.get(0) : new Producto();
    }

}
