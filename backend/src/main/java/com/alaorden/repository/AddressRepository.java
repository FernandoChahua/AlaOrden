package com.alaorden.repository;

import com.alaorden.model.Address;
import com.alaorden.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findAllByUser(User user);
}
