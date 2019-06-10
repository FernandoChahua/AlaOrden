package com.alaorden.service.impl;

import com.alaorden.model.Categoria;
import com.alaorden.repository.CategoriaRepository;
import com.alaorden.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }
    @Override
    public void Delete(Categoria entity){
        categoriaRepository.Delete(entity);
    }
    @Override
    public void Save(Categoria entity){
        categoriaRepository.Save(entity);
    }
    @Override
    public void Update(Categoria entity){
        categoriaRepository.Update(entity);
    }
    @Override
    public Categoria FindById(Categoria entity){
        return categoriaRepository.FindById(entity);
    }
    @Override
    public List<Categoria> ListAll(){
        return categoriaRepository.ListAll();
    }

}