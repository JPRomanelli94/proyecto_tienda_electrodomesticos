package com.example.sales_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sale_id;
    private LocalDate sale_date;
    private Long sale_id_trolley;
}
