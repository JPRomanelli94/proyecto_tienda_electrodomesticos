package com.example.sales_service.repository;

import com.example.sales_service.dto.SalesDTO;
import com.example.sales_service.model.Trolley;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="trolleys-service")
public interface IAPITrolley {

    @GetMapping("trolleys/id/{id}")
    public Trolley getTrolleysById(@PathVariable Long id);

}
