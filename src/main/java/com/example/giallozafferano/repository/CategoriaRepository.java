package com.example.giallozafferano.repository;

import com.example.giallozafferano.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByCategoria(String categoria);
}
