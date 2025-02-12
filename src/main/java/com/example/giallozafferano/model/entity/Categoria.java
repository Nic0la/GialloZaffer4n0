package com.example.giallozafferano.model.entity;

import com.example.giallozafferano.model.dto.RicettaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Categoria extends BaseEntity {
    private String categoria;

    @OneToMany(mappedBy = "categoria")
    private List<Ricetta> ricetteXCategoria;

}
