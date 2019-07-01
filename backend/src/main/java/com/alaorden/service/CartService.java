package com.alaorden.service;

import com.alaorden.model.CartItem;
import com.alaorden.repository.CartItemRepository;

import java.util.List;

public interface CartService {
    List<CartItem> findByUser(int id);
    void saveToCart(CartItem entity);
    void deleteFromCart(CartItem entity);
    void deleteByUserId(int id);
    CartItem findByUserAndProduct(int idUser,int idProduct);
    void deleteByUserAndProduct(int idUser,int idProduct);
}
