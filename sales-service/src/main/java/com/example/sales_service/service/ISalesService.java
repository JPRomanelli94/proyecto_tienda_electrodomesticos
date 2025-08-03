package com.example.sales_service.service;

import com.example.sales_service.dto.SalesDTO;
import com.example.sales_service.model.Sales;

import java.util.List;

public interface ISalesService {
    List<Sales> getSales();

    SalesDTO getSalesById(Long id);

    void create_sales(Sales sale);

    void delete_sales(Long id);

    void edit_sales(Long id, Sales sale);
}
