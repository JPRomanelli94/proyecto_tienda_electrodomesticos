package com.example.sales_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Trolley {

    private Long id_trolley;
    private Double price_trolley;
    private List<String> name_products;

}
