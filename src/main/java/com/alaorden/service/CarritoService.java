package com.alaorden.service;

import com.alaorden.model.CarritoItem;
import com.alaorden.repository.CarritoItemRepository;

import java.util.List;

public interface CarritoService {
    List<CarritoItem> findByUsuario(int id);
    void saveToCart(CarritoItem entity);
    void deleteFromCart(CarritoItem entity);
    void emptyCart(int id);
}
