package com.alaorden.service.impl;

import com.alaorden.model.CartItem;
import com.alaorden.repository.CartItemRepository;
import com.alaorden.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private CartItemRepository cartItemRepository;

    @Autowired
    public CartServiceImpl(CartItemRepository cartItemRepository){
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> findByUser(int id){
        return cartItemRepository.findAllByUserIdUser(id);
    }

    @Transactional
    public void saveToCart(CartItem entity){
        cartItemRepository.save(entity);
    }

    @Transactional
    public void deleteFromCart(CartItem entity){
        cartItemRepository.delete(entity);
    }

    @Transactional
    public void emptyCart(int id){
        cartItemRepository.deleteAllByUserIdUser(id);
    }
}
