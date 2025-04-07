package com.example.sales_service.controller;

import com.example.sales_service.dto.SalesDTO;
import com.example.sales_service.model.Sales;
import com.example.sales_service.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private ISalesService serv_sales;

    @GetMapping("/all")
    public List<Sales> getSales(){
        return serv_sales.getSales();
    }

    @GetMapping("/id/{id}")
    public SalesDTO getSalesById(@PathVariable Long id){
        return serv_sales.getSalesById(id);
    }

    @PostMapping("/create")
    public String create_trolleys (@RequestBody Sales sale){
        serv_sales.create_sales(sale);
        return "The sale was created correctly.";
    }

    @DeleteMapping("/delete/{id}")
    public String delete_trolleys(@PathVariable Long id){
        serv_sales.delete_sales(id);
        return "The sale was deleted correctly.";
    }

    @PutMapping("/edit/{id}")
    public String edit_sales (@PathVariable Long id, @RequestBody Sales sale){
        serv_sales.edit_sales(id, sale);
        return "The sale was modified correctly.";
    }
}
