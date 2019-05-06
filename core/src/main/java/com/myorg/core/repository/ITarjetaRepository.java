package com.myorg.core.repository;

import com.myorg.core.entity.Tarjeta;
import java.util.List;

public interface ITarjetaRepository extends IJpaRepository<Tarjeta> {
    List<Tarjeta> findAllByUsuario(int idUsuario) throws Exception;
}
