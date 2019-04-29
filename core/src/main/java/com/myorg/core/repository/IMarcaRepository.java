package com.myorg.core.repository;

import com.myorg.core.entity.Marca;

public interface IMarcaRepository extends IJpaRepository<Marca> {
    Marca findByName(Marca m);
}
