package com.alaorden.service;

import com.alaorden.model.*;

import java.util.*;
import java.math.BigDecimal;

public interface QuotationService {
    List<Order> generateList(List<CartItem> cart, Map<Location,BigDecimal> available);
    List<OrderDetail> generateListByFranchise(List<CartItem> cart, Franchise prov);
    OrderDetail empaquetar(CartItem busq, Franchise prov);
    String getCodRef(CartItem busq, Franchise prov);
}
