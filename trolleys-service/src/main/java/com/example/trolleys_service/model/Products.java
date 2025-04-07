package com.example.trolleys_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Products {

    private Long product_id;
    private String product_name;
    private String product_brand;
    private Double product_price;

}
