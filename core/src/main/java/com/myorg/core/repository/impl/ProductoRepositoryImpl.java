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
import javax.persistence.TypedQuery;

@Named
public class ProductoRepositoryImpl implements Serializable, IProductoRepository {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;
    
    @Override
    public boolean insert(Producto p)throws Exception  {
            boolean rpta = false;
            try{
                em.persist(p);
                rpta = true;
            }catch(Exception ex){
                throw ex;
            }
            return rpta;
    }
    
    @Override
    public boolean update(Producto p) throws Exception {
            boolean rpta = false;
            try{
                em.merge(p);
            }catch(Exception ex){
                throw ex;
            }
            return rpta;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Producto> findAll() throws Exception {
            List<Producto> productos = new ArrayList<>();
            TypedQuery<Producto> productoExists = null;
            try{
                Query q = em.createQuery("SELECT p FROM producto p");
            }catch(Exception ex){
                productos = new ArrayList<>();
            }
                productos = productoExists.getResultList();
            return productos;
    }

    @Override
    public boolean delete(Producto p) throws Exception {
            boolean rpta = false;
            try{
                em.remove(p);
            }catch(Exception ex){
                throw ex;
            }
            return rpta;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Producto findById(Producto p) throws Exception {
            List<Producto> productos = new ArrayList<>();
            TypedQuery<Producto> productoExists = null;
            try{
                Query q = em.createQuery("FROM producto p where p.idProducto = ?1");
                q.setParameter(1, p.getIdProducto());
            }catch(Exception ex){
                productos = new ArrayList<>();
            }
            productos = productoExists.getResultList();
            return productos != null && !productos.isEmpty() ? productos.get(0) : new Producto();
    }

}
