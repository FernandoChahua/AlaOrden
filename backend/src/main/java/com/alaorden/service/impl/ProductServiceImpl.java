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

import java.util.*;

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
        List<Product> products = productRepository.findAll();
        for(int i=0;i<products.size();i++){
            products.get(i).getCategory().setParent(null);
            products.get(i).getCategory().setProducts(null);
        }
        return products;
    }
    public List<Category> listCategories(){
        List<Category> categorias = new ArrayList<>();
        categorias = categoryRepository.findAll();
        List<Category> categories = new ArrayList<>();
        for(int i=0;i<categorias.size();i++){
            List<Category> subcategories = new ArrayList<>();
            if(categorias.get(i).getParent() == null) {
                for (int j = 0; j < categorias.size(); j++) {
                    if (i!=j){
                        if(categorias.get(j).getParent() !=null && categorias.get(j).getParent().getIdCategory() == categorias.get(i).getIdCategory()){
                           categorias.get(j).setParent(null);
                           categorias.get(j).setProducts(null);
                           subcategories.add(categorias.get(j));
                        }
                    }
                }
                categorias.get(i).setSubCategories(subcategories);
                categories.add(categorias.get(i));
            }
        }

        List<Category> categoriasFilter = new ArrayList<>();

        for(int i=0;i<categories.size();i++){
            if(categories.get(i).getSubCategories().size()>0){
                categoriasFilter.add(categories.get(i));
            }
        }

        return categoriasFilter;
    }
    public List<Brand> listBrand(){
        return brandRepository.findAll();
    }

    public List<Product> listProductsByCategory(int id){
        List<Product> products = productRepository.findAllByCategoryIdCategory(id);
        for(int i=0;i<products.size();i++){
            products.get(i).getCategory().setParent(null);
            products.get(i).getCategory().setProducts(null);
        }
        return products;
    }
    public List<Product> listProductSearch(String name){
        List<Product> products = productRepository.findByNameContaining(name);

        for(int i=0;i<products.size();i++){
            products.get(i).getCategory().setParent(null);
            products.get(i).getCategory().setProducts(null);
        }
        return products;
    }

}
