package com.alaorden.service.impl;

import com.alaorden.model.CartItem;
import com.alaorden.model.Order;
import com.alaorden.repository.OrderRepository;
import com.alaorden.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order GenerateOrder(List<CartItem> cart){
        return new Order();
    }
    public Order listOrderByUser(Order order){
        return null;
    }


}
