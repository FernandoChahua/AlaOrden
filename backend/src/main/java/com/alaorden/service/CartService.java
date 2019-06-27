package com.alaorden.service;

import com.alaorden.model.CartItem;
import com.alaorden.repository.CartItemRepository;

import java.util.List;

public interface CartService {
    List<CartItem> findByUser(int id);
    void saveToCart(CartItem entity);
    void deleteFromCart(CartItem entity);
    void emptyCart(int id);
}
