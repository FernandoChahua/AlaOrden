package com.alaorden.service;
import com.alaorden.model.*;
import java.util.List;

public interface CouponService {
    List<Coupon> listAllCoupon();
    Coupon findByIdCoupon(int idCoupon);
    void deleteCoupon(int idCoupon);
    void updateCoupon(Coupon coupon);
    void createCoupon(Coupon coupon);
}
