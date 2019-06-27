package com.alaorden.service.impl;

import com.alaorden.model.Category;
import com.alaorden.model.Brand;
import com.alaorden.model.Product;
import com.alaorden.repository.CategoryRepository;
import com.alaorden.repository.BrandRepository;
import com.alaorden.repository.ProductRepository;
import com.alaorden.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    public ProductRepository productRepository;
    public CategoryRepository categoryRepository;
    public BrandRepository brandRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, BrandRepository brandRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }
    public List<Category> listCategories(){
        return categoryRepository.findAll();
    }
    public List<Brand> listBrand(){
        return brandRepository.findAll();
    }

}
