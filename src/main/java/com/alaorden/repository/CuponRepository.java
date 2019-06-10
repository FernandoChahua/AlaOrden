package com.alaorden.repository;
import com.alaorden.model.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuponRepository extends JpaRepository<Cupon, Integer> {
}
