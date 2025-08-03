package com.example.products_service.service;

import com.example.products_service.model.Products;
import com.example.products_service.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repo_prod;

    @Override
    public List<Products> getProducts() {
        return repo_prod.findAll();
    }

    @Override
    public Products getProductsById(Long id) {
        return repo_prod.findById(id).orElse(null);
    }

    @Override
    public void create_products(Products product) {
        repo_prod.save(product);
    }

    @Override
    public void delete_products(Long id) {
        repo_prod.deleteById(id);
    }

    @Override
    public void edit_products(Long id, Products product) {

        List<Products> allProducts = this.getProducts();

        //For each
        for (Products products : allProducts){
            if (products.getProduct_id().equals(id)){
                products.setProduct_name(product.getProduct_name());
                products.setProduct_brand(product.getProduct_brand());
                products.setProduct_price(product.getProduct_price());
                repo_prod.save(products);
            }

        }
    }
}
