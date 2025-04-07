package com.example.products_service.service;

import com.example.products_service.model.Products;

import java.util.List;

public interface IProductService {

    List<Products> getProducts();

    Products getProductsById(Long id);

    void create_products(Products product);

    void delete_products(Long id);

    void edit_products(Long id, Products product);
}
