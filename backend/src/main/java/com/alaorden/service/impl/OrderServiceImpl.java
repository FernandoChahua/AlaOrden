package com.alaorden.service.impl;

import com.alaorden.model.CartItem;
import com.alaorden.model.Orders;
import com.alaorden.repository.OrdersRepository;
import com.alaorden.service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrdersRepository ordersRepository;

    @Autowired
    public OrderServiceImpl(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    public Orders GenerateOrder(List<CartItem> cart){
        return new Orders();
    }
    public Orders listOrderByUser(Orders order){
        return null;
    }
    public Orders SaveOrder(Orders order){
        return ordersRepository.save(order);
    }

}
