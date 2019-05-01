package com.myorg.core.repository.impl;

import com.myorg.core.entity.Rol;
import com.myorg.core.repository.IRolRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Named
public class RolRepositoryImpl implements IRolRepository {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "visorPU")
    EntityManager em;
    
    @Override
    public boolean insert(Rol r) throws Exception {
        em.persist(r);
        return true;
    }

    @Override
    public boolean update(Rol r) throws Exception {
        em.merge(r);
        return true;
    }

    @Override
    public boolean delete(Rol r) throws Exception {
        em.remove(r);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Rol findById(Rol r) throws Exception {
            List<Rol> list = new ArrayList<>();
        try{
            Query q = em.createQuery("SELECT r FROM Rol r WHERE r.idRol = ?1");
            q.setParameter(1, r.getIdRol());
            list = (List<Rol>) q.getResultList();
        }catch(Exception e){
            throw e;
        }
        return list != null && !list.isEmpty() ? list.get(0) : new Rol();
    }
    
    @Override
    public Rol findByNombre(Rol r) {
        List<Rol> list = new ArrayList<>();
        Query q = em.createQuery("SELECT r FROM Rol r WHERE r.nombre = ?1");
        q.setParameter(1, r.getIdRol());
        list = (List<Rol>) q.getResultList();
        return list != null && !list.isEmpty() ? list.get(0) : new Rol();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Rol> findAll() throws Exception {
        TypedQuery<Rol> query = em.createQuery("SELECT r FROM Rol r", Rol.class);
        return query.getResultList();
    }

}
