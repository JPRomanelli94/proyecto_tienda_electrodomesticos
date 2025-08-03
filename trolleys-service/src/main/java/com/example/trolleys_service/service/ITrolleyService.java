package com.example.trolleys_service.service;

import com.example.trolleys_service.dto.TrolleyDTO;
import com.example.trolleys_service.model.Trolleys;

import java.util.List;

public interface ITrolleyService {
    List<Trolleys> getTrolleys();

    TrolleyDTO getTrolleysById(Long id);

    void create_trolleys(Trolleys trolley);

    void delete_trolleys(Long id);

    void edit_trolleys(Long id, Trolleys trolley);
}
