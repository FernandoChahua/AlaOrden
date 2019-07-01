package com.alaorden.repository;
import com.alaorden.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    Coupon findByCode(String code);
}
