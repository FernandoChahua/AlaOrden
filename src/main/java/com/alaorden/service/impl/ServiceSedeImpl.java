package com.alaorden.service.impl;

import com.alaorden.model.Sede;
import com.alaorden.repository.RepositorySede;
import com.alaorden.service.ServiceSede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSedeImpl implements ServiceSede {
    RepositorySede repositorySede;

    @Autowired
    public ServiceSedeImpl(RepositorySede repositorySede){
        this.repositorySede = repositorySede;
    }
    @Override
    public void Delete(Sede entity){
        repositorySede.Delete(entity);
    }
    @Override
    public void Save(Sede entity){
        repositorySede.Save(entity);
    }
    @Override
    public void Update(Sede entity){
        repositorySede.Update(entity);
    }
    @Override
    public Sede FindById(Sede entity){
        return repositorySede.FindById(entity);
    }
    @Override
    public List<Sede> ListAll(){
        return repositorySede.ListAll();
    }

}