package com.myorg.core.repository;

import com.myorg.core.entity.Categoria;

public interface ICategoriaRepository extends IJpaRepository<Categoria> {
    Categoria findByName(Categoria c);
}
