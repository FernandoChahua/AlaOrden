package com.alaorden.repository;
import com.alaorden.model.CarritoItem;
import com.alaorden.model.CarritoItemKey;
import org.hibernate.type.CharacterArrayType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoItemRepository extends JpaRepository<CarritoItem,Integer> {
    List<CarritoItem> findAllByUsuarioIdUsuario(int id);

    void deleteAllByUsuarioIdUsuario(int id);

}
