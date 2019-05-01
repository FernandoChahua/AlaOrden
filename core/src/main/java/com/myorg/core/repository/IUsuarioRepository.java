package com.myorg.core.repository;

import com.myorg.core.entity.Usuario;

public interface IUsuarioRepository extends IJpaRepository<Usuario>{
    Usuario findByApodo(String apodo);
    Usuario findByEmail(String email);
}
