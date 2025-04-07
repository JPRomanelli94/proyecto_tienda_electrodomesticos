package com.example.sales_service.repository;

import com.example.sales_service.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesRepository extends JpaRepository<Sales,Long> {
}
