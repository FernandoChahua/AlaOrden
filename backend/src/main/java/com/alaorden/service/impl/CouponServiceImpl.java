package com.alaorden.service.impl;
import com.alaorden.model.*;
import com.alaorden.repository.CouponRepository;
import com.alaorden.service.CouponService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    private CouponRepository couponRepository;
    public CouponServiceImpl(CouponRepository couponRepository){
        this.couponRepository = couponRepository;
    }

    //////////// CRUD
    public List<Coupon> listAllCoupon(){
        return couponRepository.findAll();
    }

    public Coupon findByIdCoupon(int idCoupon){
        return couponRepository.findByIdCoupon(idCoupon);
    }
    @Transactional
    public void deleteCoupon(int idCoupon){ /////////////// REGLA DE NEGOCIO ---- NO BORRAR CUPONES SOLO DESACTIVARLO
        Coupon coupon = findByIdCoupon(idCoupon);
        if(coupon!=null){
            if(coupon.isActive()){
                coupon.setActive(false);
                coupon.setExpirationDate(LocalDateTime.now());
            }
        }
    }
    @Transactional
    public void updateCoupon(Coupon coupon){
        Coupon c = findByIdCoupon(coupon.getIdCoupon());
        if(c!=null) {
            couponRepository.save(coupon);
        }
    }
    @Transactional
    public void createCoupon(Coupon coupon){
        couponRepository.save(coupon);
    }
}

