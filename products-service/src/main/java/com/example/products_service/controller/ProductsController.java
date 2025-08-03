package com.example.products_service.controller;

import com.example.products_service.model.Products;
import com.example.products_service.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private IProductService serv_prod;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/all")
    public List<Products> getProducts(){
        return serv_prod.getProducts();
    }

    @GetMapping("/id/{id}")
    public Products getProductsById(@PathVariable Long id){
        System.out.println("Puerto en el que se hace consulta: " + serverPort);
        return serv_prod.getProductsById(id);
    }

    @PostMapping("/create")
    public String create_products (@RequestBody Products product){
        serv_prod.create_products(product);
        return "The product was created correctly.";
    }

    @DeleteMapping("/delete/{id}")
    public String delete_products (@PathVariable Long id){
        serv_prod.delete_products(id);
        return "The product was deleted correctly.";
    }

    @PutMapping("/edit/{id}")
    public String edit_products (@PathVariable Long id, @RequestBody Products product){
        serv_prod.edit_products(id, product);
        return "The product was modified correctly.";
    }
}
