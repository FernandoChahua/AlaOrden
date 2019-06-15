package com.alaorden.repository;

import com.alaorden.model.Direccion;
import com.alaorden.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
    List<Direccion> findAllByUsuario(Usuario usuario);
}
