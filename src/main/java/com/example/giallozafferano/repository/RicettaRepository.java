package com.example.giallozafferano.repository;

import com.example.giallozafferano.model.entity.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RicettaRepository extends JpaRepository<Ricetta, Long> {

    Ricetta findByName(String name);
}
