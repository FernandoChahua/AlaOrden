package com.alaorden.service.impl;

import com.alaorden.model.CartItem;
import com.alaorden.model.User;
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
        List<CartItem>carrito = cartItemRepository.findAllByUserIdUser(id);
        for(int i=0;i<carrito.size();i++)
        {
            carrito.get(i).setUser(new User());
            carrito.get(i).getUser().setIdUser(id);
            carrito.get(i).getProduct().getCategory().setParent(null);
            carrito.get(i).getProduct().getCategory().setProducts(null);
            carrito.get(i).getProduct().getCategory().setSubCategories(null);
            carrito.get(i).getProduct().setInventory(null);
        }
        return carrito;
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

    public CartItem findByUserAndProduct(int idUser,int idProduct){
        return cartItemRepository.findByUserIdUserAndProductIdProduct(idUser,idProduct);
    }
    @Transactional
    public void deleteByUserId(int id){
        cartItemRepository.deleteAllByUserIdUser(id);
    }
    @Transactional
    public void deleteByUserAndProduct(int idUser,int idProduct){
        cartItemRepository.deleteByUserIdUserAndProductIdProduct(idUser,idProduct);
    }
}
