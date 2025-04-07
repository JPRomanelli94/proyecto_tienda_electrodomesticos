package com.example.sales_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SalesDTO {

    private Long id_sale;
    private LocalDate date_sale;
    private Double price_sale;
    private List<String> name_products_sale;

}
