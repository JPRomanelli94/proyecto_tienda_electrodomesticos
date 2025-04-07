package com.example.trolleys_service.repository;

import com.example.trolleys_service.model.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="products-service")
public interface IAPIProducts {

    @GetMapping("products/id/{id}")
    public Products getProductsById(@PathVariable Long id);
}
