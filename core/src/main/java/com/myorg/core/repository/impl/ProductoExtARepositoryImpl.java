/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.core.repository.impl;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.myorg.core.temp.ext.*;
import com.myorg.core.repository.IProductoExtARepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named
public class ProductoExtARepositoryImpl implements IProductoExtARepository {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;

    @Override
    public boolean insert(ProductoExtA p) throws Exception {
        boolean rpta = false;
        try {
            em.persist(p);
            rpta = true;
        } catch (Exception ex) {
            throw ex;
        }
        return rpta;
    }

    @Override
    public boolean update(ProductoExtA p) throws Exception {
        boolean rpta = false;
        try {
            em.merge(p);
        } catch (Exception ex) {
            throw ex;
        }
        return rpta;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProductoExtA> findAll() throws Exception {
        List<ProductoExtA> productos = new ArrayList<>();
        try {
            TypedQuery<ProductoExtA> productoExists = em.createQuery("SELECT p FROM ProductoExtA p", ProductoExtA.class);
            productos = productoExists.getResultList();
        } catch (Exception ex) {
            productos = new ArrayList<>();
        }
        return productos;
    }

    @Override
    public boolean delete(ProductoExtA p) throws Exception {
        boolean rpta = false;
        try {
            em.remove(p);
        } catch (Exception ex) {
            throw ex;
        }
        return rpta;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ProductoExtA findById(ProductoExtA p) throws Exception {
        List<ProductoExtA> productos = new ArrayList<>();
        try {
            TypedQuery<ProductoExtA> productoExists = em.createQuery("SELECT p FROM ProductoExtA p where p.id = ?1",ProductoExtA.class);
            productoExists.setParameter(1, p.getIdProductoExtA());
            productos = productoExists.getResultList();
        } catch (Exception ex) {
            productos = new ArrayList<>();
        }

        return productos != null && !productos.isEmpty() ? productos.get(0) : new ProductoExtA();
    }
    
}
