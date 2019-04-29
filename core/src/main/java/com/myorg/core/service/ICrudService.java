package com.myorg.core.service;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;

public interface ICrudService<T> extends Serializable {
    //@Transactional
    boolean insert(T t) throws Exception;
    //@Transactional
    boolean update(T t) throws Exception;
    //@Transactional
    boolean delete(T t) throws Exception;
    T findById(T t) throws Exception;
    List<T> findAll() throws Exception;
}
