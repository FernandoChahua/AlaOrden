package com.alaorden.service;

import java.util.List;

public interface ServiceCRUD<T> {
    void Delete(T entity);
    void Save(T entity);
    void Update(T entity);
    T FindById(T entity);
    List<T> ListAll();
}
