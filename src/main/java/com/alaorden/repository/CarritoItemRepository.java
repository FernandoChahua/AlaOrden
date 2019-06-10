package com.alaorden.repository;
import com.alaorden.model.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoItemRepository extends JpaRepository<CarritoItem,Integer> {
}
