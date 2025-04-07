package com.example.products_service.repository;

import com.example.products_service.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Products,Long> {
}
