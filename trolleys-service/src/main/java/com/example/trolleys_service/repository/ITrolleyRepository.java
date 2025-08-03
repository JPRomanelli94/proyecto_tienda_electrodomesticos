package com.example.trolleys_service.repository;

import com.example.trolleys_service.model.Trolleys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrolleyRepository extends JpaRepository<Trolleys,Long> {
}
