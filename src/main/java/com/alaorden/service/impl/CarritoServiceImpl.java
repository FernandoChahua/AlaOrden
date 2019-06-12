package com.alaorden.service.impl;

import com.alaorden.model.CarritoItem;
import com.alaorden.repository.CarritoItemRepository;
import com.alaorden.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarritoServiceImpl implements CarritoService {

    private CarritoItemRepository carritoItemRepository;

    @Autowired
    public CarritoServiceImpl(CarritoItemRepository carritoItemRepository){
        this.carritoItemRepository = carritoItemRepository;
    }

    public List<CarritoItem> findByUsuario(int id){
        return carritoItemRepository.findAllByUsuarioIdUsuario(id);
    }

    @Transactional
    public void saveToCart(CarritoItem entity){
        carritoItemRepository.save(entity);
    }

    @Transactional
    public void deleteFromCart(CarritoItem entity){
        carritoItemRepository.delete(entity);
    }

    @Transactional
    public void emptyCart(int id){
        carritoItemRepository.deleteAllByUsuarioIdUsuario(id);
    }
}
