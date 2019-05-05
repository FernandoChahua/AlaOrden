package com.myorg.core.service.comm.ext;

import java.io.Serializable;
import java.util.List;

public interface IProductoExtARepository extends Serializable{
    Product findById(Product t) throws Exception;
    List<Product> findAll() throws Exception;
}

