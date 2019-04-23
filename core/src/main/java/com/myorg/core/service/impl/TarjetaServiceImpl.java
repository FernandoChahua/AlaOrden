package com.myorg.core.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.myorg.core.repository.impl.*;
import com.myorg.core.entity.*;
import com.myorg.core.service.ITarjetaService;
import javax.transaction.Transactional;


@Named
public class TarjetaServiceImpl implements Serializable, ITarjetaService{

    private static final long serialVersionUID = 1L;
	
    @Inject
    private TarjetaRepositoryImpl tarjetaRepository;
    
    @Transactional
    @Override
    public boolean insert(Tarjeta t) throws Exception {
        boolean rpta = false;
        try{
            tarjetaRepository.insert(t);
            rpta = true;
        }catch(Exception ex){
            throw ex;
        }
        return rpta;
    }

    @Override
    public List<Tarjeta> findAll()throws Exception {
        try{
            return tarjetaRepository.findAll();
        }catch(Exception ex){
            throw ex;
        }
    }

    @Transactional
    @Override
    public boolean update(Tarjeta t) throws Exception {
        boolean rpta = false;
        try{
            tarjetaRepository.update(t);
            rpta = true;
        }catch(Exception ex){
            throw ex;
        }
        return rpta;
    }

    @Transactional
    @Override
    public boolean delete(Tarjeta t) throws Exception {
        boolean rpta = false;
        try{
            tarjetaRepository.delete(t);
            rpta = true;
        }catch(Exception ex){
            throw ex;
        }
        return rpta;
    }

    @Override
    public Tarjeta findById(Tarjeta t) throws Exception {
        try{
            return tarjetaRepository.findById(t);
        }catch(Exception ex){
            throw ex;
        }
    }
	

}
