package com.example.trolleys_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Trolleys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trolley_id;
    private Double trolley_price;

    //la lista de electrodomesticos es únicamente de los nombres de los mismos
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> trolley_id_appliances;

}
