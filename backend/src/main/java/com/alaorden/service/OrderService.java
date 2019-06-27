package com.alaorden.service;

import com.alaorden.model.CartItem;
import com.alaorden.model.Order;

import java.util.List;

public interface OrderService {

    Order GenerateOrder(List<CartItem> cart);
    Order listOrderByUser(Order order);

}
