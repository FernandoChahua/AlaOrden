package com.alaorden.service.impl;

import com.alaorden.model.OrderDetail;
import com.alaorden.repository.OrderDetailRepository;
import com.alaorden.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl {

      private OrderDetailRepository orderDetailRepository;
    @Autowired
      public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository){
          this.orderDetailRepository = orderDetailRepository;
      }
      public  void SaveDetailOrder(List<OrderDetail> orderDetails){
              orderDetailRepository.saveAll(orderDetails);
      }


}
