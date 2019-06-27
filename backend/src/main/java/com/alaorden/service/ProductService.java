package com.alaorden.service;

import com.alaorden.model.Category;
import com.alaorden.model.Brand;
import com.alaorden.model.Product;

import java.util.List;

public interface ProductService {
     List<Product> listProducts();
     List<Category> listCategories();
     List<Brand> listBrand();
}
