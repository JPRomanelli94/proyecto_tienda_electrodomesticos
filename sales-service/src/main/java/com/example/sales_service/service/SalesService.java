package com.example.sales_service.service;

import com.example.sales_service.dto.SalesDTO;
import com.example.sales_service.model.Sales;
import com.example.sales_service.model.Trolley;
import com.example.sales_service.repository.IAPITrolley;
import com.example.sales_service.repository.ISalesRepository;
import com.netflix.discovery.converters.Auto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalesService implements ISalesService {

    @Autowired
    private ISalesRepository repo_sales;

    @Autowired
    private IAPITrolley api_troll;

    @Override
    public List<Sales> getSales() {
        return repo_sales.findAll();
    }

    @Override
    @CircuitBreaker(name="trolleys-service",fallbackMethod = "fallbackGetSalesById")
    @Retry(name="trolleys-service")
    public SalesDTO getSalesById(Long id) {

        //busco mi venta en mi base de datos
        Sales sale = repo_sales.findById(id).orElse(null);

        //busco el carrito en el servicio trolleys-service
        Trolley trolley = api_troll.getTrolleysById(sale.getSale_id_trolley());

        //va a incluir, llevar el id del carrito para saber precio total + detalle de nombres de productos
        SalesDTO salesTrolley = new SalesDTO(id,sale.getSale_date(),trolley.getPrice_trolley(),trolley.getName_products());

        createException();

        return salesTrolley;
    }

    @Override
    public void create_sales(Sales sale) {
        repo_sales.save(sale);
    }

    @Override
    public void delete_sales(Long id) {
        repo_sales.deleteById(id);
    }

    @Override
    public void edit_sales(Long id, Sales sale) {

        List<Sales> allSales = this.getSales();

        //For each
        for (Sales sales: allSales){
            if (sales.getSale_id().equals(id)){
                sales.setSale_date(sale.getSale_date());
                sales.setSale_id_trolley(sale.getSale_id_trolley());
                repo_sales.save(sales);
            }
        }

    }

    public void createException(){

        throw new IllegalArgumentException("Circuit Breaker");

    }

    public SalesDTO fallbackGetSalesById (Throwable throwable){
        return new SalesDTO(9999999999L,LocalDate.now(),0.00,null);
    }

}
