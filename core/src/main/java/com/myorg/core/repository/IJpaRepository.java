package com.myorg.core.repository;

import java.util.List;

public interface IJpaRepository<T> {
    
    boolean insert(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(T t) throws Exception;
    T findById(int id) throws Exception;
    List<T> findAll() throws Exception;
}
