package com.myorg.core.repository.impl;

import java.util.List;

import com.myorg.core.entity.*;
import java.util.ArrayList;
import javax.inject.Named;
import javax.persistence.*;
import com.myorg.core.repository.IUsuarioRepository;

@Named
public class UsuarioRepositoryImpl implements IUsuarioRepository {
    
    private static final long serialVersionUID = 1L;
        
    @PersistenceContext(unitName = "visorPU")
    private EntityManager em;
    
    @Override
    public Usuario findByApodo(String apodo) {
        List<Usuario> list = new ArrayList<>();

        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.apodo = ?1");
            q.setParameter(1, apodo);
            list = (List<Usuario>) q.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return (list != null && !list.isEmpty() )? list.get(0) : new Usuario() ;
    }

    @Override
    public Usuario findByEmail(String email) {
        List<Usuario> list = new ArrayList<>();

        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = ?1");
            q.setParameter(1, email);
            list = (List<Usuario>) q.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return (list != null && !list.isEmpty() )? list.get(0) : new Usuario() ;
    }
    
    @Override
    public boolean insert(Usuario u) throws Exception {
        boolean rpta = false;
        try {
            em.persist(u);
            rpta = true;
        } catch (Exception ex) {
            throw ex;
        }
        return rpta;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Usuario> findAll() throws Exception {
        List<Usuario> list = new ArrayList<>();

        try {
            Query q = em.createQuery("SELECT u FROM Usuario u");
            list = (List<Usuario>) q.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public boolean update(Usuario u) throws Exception {
        boolean rpta = false;
        try {
            em.merge(u);
            rpta = true;
        } catch (Exception ex) {
            throw ex;
        }
        return rpta;
    }

    @Override
    public boolean delete(Usuario u) throws Exception {
        boolean rpta = false;
        try {
            em.persist(u);
            rpta = true;
        } catch (Exception ex) {
            throw ex;
        }
        return rpta;
    }

    @Override
    public Usuario findById(Usuario u) throws Exception {
        List<Usuario> list = new ArrayList<>();

        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = ?1");
            q.setParameter(1, u.getIdUsuario());
            list = (List<Usuario>) q.getResultList();
        } catch (Exception ex) {
            throw ex;
        }
        return (list != null && !list.isEmpty() )? list.get(0) : new Usuario() ;
    }

    
}
