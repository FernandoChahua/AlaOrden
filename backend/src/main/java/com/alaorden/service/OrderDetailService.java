package com.alaorden.service;

import com.alaorden.model.CartItem;
import com.alaorden.model.OrderDetail;
import com.alaorden.model.Orders;
import com.alaorden.model.Orders;

import java.util.List;

public interface OrderDetailService {
    void SaveDetailOrder(List<OrderDetail> orderDetails);
}
