package com.alaorden.service.impl;

import com.alaorden.model.Cupon;
import com.alaorden.repository.RepositoryCupon;
import com.alaorden.service.ServiceCupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCuponImpl implements ServiceCupon {
    RepositoryCupon repositoryCupon;

    @Autowired
    public ServiceCuponImpl(RepositoryCupon repositoryCupon){
        this.repositoryCupon = repositoryCupon;
    }
    @Override
    public void Delete(Cupon entity){
        repositoryCupon.Delete(entity);
    }
    @Override
    public void Save(Cupon entity){
        repositoryCupon.Save(entity);
    }
    @Override
    public void Update(Cupon entity){
        repositoryCupon.Update(entity);
    }
    @Override
    public Cupon FindById(Cupon entity){
        return repositoryCupon.FindById(entity);
    }
    @Override
    public List<Cupon> ListAll(){
        return repositoryCupon.ListAll();
    }

}