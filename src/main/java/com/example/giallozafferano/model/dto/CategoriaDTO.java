package com.example.giallozafferano.model.dto;

import com.example.giallozafferano.model.entity.Ricetta;

import java.util.List;

public class CategoriaDTO
{
    private Long id;
    private String categoria;
    private List<Ricetta> ricetteXCategoria;

    public List<Ricetta> getRicetteXCategoria() {
        return ricetteXCategoria;
    }

    public void setRicetteXCategoria(List<Ricetta> ricetteXCategoria) {
        this.ricetteXCategoria = ricetteXCategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
