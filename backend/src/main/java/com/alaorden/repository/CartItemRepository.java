package com.alaorden.repository;
import com.alaorden.model.CartItem;
import com.alaorden.model.CartItemKey;
import org.hibernate.type.CharacterArrayType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    List<CartItem> findAllByUserIdUser(int id);
    CartItem findByUserIdUserAndProductIdProduct(int idUser,int idProduct);
    void deleteAllByUserIdUser(int id);
    void deleteByUserIdUserAndProductIdProduct(int idUser,int idProduct);

}
