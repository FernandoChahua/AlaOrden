package com.alaorden.service.impl;

import com.alaorden.model.Coupon;
import com.alaorden.model.Transaction;
import com.alaorden.repository.CouponRepository;
import com.alaorden.repository.TransactionRepository;
import com.alaorden.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Service
public class TransactionServiceImpl implements TransactionService {
    private CouponRepository couponRepository;
    private TransactionRepository transactionRepository;
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,CouponRepository couponRepository){
        this.transactionRepository = transactionRepository;
        this.couponRepository = couponRepository;
    }

    @Transactional
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
    @Transactional
    public Coupon saveCoupon(Coupon coupon){
        return couponRepository.save(coupon);
    }
    @Transactional
    public Coupon validarCoupon(String code){
        Coupon coupon = couponRepository.findByCode(code);
        if(coupon != null){
            if(coupon.isActive()){
                coupon.setActive(false);
                couponRepository.save(coupon);
                return coupon;
            }
        }
            Coupon aux = new Coupon();
            aux.setIdCoupon(0);
            aux.setDiscount(BigDecimal.valueOf(0));
        return aux;
    }

}
