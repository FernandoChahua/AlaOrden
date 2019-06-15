package com.alaorden.repository;

import com.alaorden.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByApodoEquals(String apodo);
    Usuario findByEmailEquals(String email);
}
