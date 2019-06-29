package com.alaorden.repository;

import com.alaorden.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByCategoryIdCategory(int id);

    List<Product> findByNameIsContaining(String name);

}
