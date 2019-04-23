package com.myorg.core.service;

import java.util.List;

public interface ICrudService<T> {
    boolean insert(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(T t) throws Exception;
    T findById(T t) throws Exception;
    List<T> findAll() throws Exception;
}
