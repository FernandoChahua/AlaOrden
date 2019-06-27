package com.alaorden.repository;
import com.alaorden.model.CartItem;
import com.alaorden.model.CartItemKey;
import org.hibernate.type.CharacterArrayType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    List<CartItem> findAllByUserIdUser(int id);
    void deleteAllByUserIdUser(int id);

}
