package com.alaorden.service;

import com.alaorden.model.*;

import java.util.*;
import java.math.BigDecimal;

public interface QuotationService {
    List<Orders> generateList(List<CartItem> cart, List<Location> available);
    List<OrderDetail> generateListByFranchise(List<CartItem> cart, Franchise prov);
}
