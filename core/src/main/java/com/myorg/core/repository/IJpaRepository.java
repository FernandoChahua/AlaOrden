package com.myorg.core.repository;

import java.io.Serializable;
import java.util.List;

public interface IJpaRepository<T> extends Serializable {
    
    boolean insert(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(T t) throws Exception;
    T findById(T t) throws Exception;
    List<T> findAll() throws Exception;
}
