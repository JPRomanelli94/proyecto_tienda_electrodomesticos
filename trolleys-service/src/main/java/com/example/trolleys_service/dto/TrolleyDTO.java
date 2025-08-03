package com.example.trolleys_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class TrolleyDTO {

    private Long id_trolley;
    private Double price_trolley;
    private List<String> name_products;

}
