package com.alaorden.controller;

import com.alaorden.model.Coupon;
import com.alaorden.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    CouponService couponService;
    @Autowired
    public CouponController(CouponService couponService){
        this.couponService = couponService;
    }

    //// CRUD CONTROLLERS
    @RequestMapping(method= RequestMethod.GET)
    public List<Coupon> listCoupons(){
        return couponService.listAllCoupon();
    }
    @RequestMapping(path="/{idCoupon}",method= RequestMethod.GET)
    public Coupon findById(@PathVariable int idCoupon){
        return couponService.findByIdCoupon(idCoupon);
    }
    @RequestMapping(path="/{idCoupon}",method= RequestMethod.DELETE)
    public void deleteCoupon(@PathVariable int idCoupon){
        couponService.deleteCoupon(idCoupon);
    }
    @RequestMapping(method= RequestMethod.PUT)
    public void updateCoupon(@RequestBody Coupon coupon){
        couponService.updateCoupon(coupon);
    }
    @RequestMapping(method= RequestMethod.POST)
    public void createCoupon(@RequestBody Coupon coupon){
        couponService.createCoupon(coupon);
    }

}
