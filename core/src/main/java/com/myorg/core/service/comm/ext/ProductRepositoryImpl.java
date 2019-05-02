/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.core.service.comm.ext;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.myorg.core.service.comm.ext.IProductoExtARepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named
public class ProductRepositoryImpl implements IProductoExtARepository {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> findAll() throws Exception {
        List<Product> products = new ArrayList<>();
        try {
            TypedQuery<Product> productExists = em.createQuery("SELECT p FROM Product p", Product.class);
            products = productExists.getResultList();
        } catch (Exception ex) {
            products = new ArrayList<>();
        }
        return products;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Product findById(Product p) throws Exception {
        List<Product> products = new ArrayList<>();
        try {
            TypedQuery<Product> productExists = em.createQuery("SELECT p FROM Product p where p.id = ?1",Product.class);
            productExists.setParameter(1, p.getClass());
            products = productExists.getResultList();
        } catch (Exception ex) {
            products = new ArrayList<>();
        }

        return products != null && !products.isEmpty() ? products.get(0) : new Product();
    }
}
