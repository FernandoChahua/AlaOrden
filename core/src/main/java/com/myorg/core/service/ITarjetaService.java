/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.core.service;

import com.myorg.core.entity.Tarjeta;
import java.util.List;

/**
 *
 * @author Alexia
 */
public interface ITarjetaService extends ICrudService<Tarjeta> {
    List<Tarjeta> findAllByUsuario(int idUsuario) throws Exception;
}
