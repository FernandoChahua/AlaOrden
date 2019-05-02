package com.myorg.core.service.comm.ext;

import java.util.List;

public interface IProductoExtARepository {
    Product findById(Product t) throws Exception;
    List<Product> findAll() throws Exception;
}

