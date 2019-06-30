package com.alaorden.service;

import com.alaorden.model.CartItem;
import com.alaorden.model.Orders;
import com.alaorden.model.Orders;

import java.util.List;

public interface OrderService {

    Orders GenerateOrder(List<CartItem> cart);
    Orders listOrderByUser(Orders order);

}
