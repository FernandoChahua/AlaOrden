package com.alaorden.repository;

import java.util.List;

public  interface RepositoryCRUD<T> {
    void Delete(T entity);
    void Save(T entity);
    void Update(T entity);
    T FindById(T entity);
    List<T> ListAll();
}
