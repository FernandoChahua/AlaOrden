package com.alaorden.service;

import com.alaorden.model.Coupon;
import com.alaorden.model.Transaction;
import com.alaorden.repository.TransactionRepository;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
    Coupon saveCoupon(Coupon coupon);
    Coupon validarCoupon(String code);
}
