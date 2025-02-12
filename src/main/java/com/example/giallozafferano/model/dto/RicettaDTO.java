package com.example.giallozafferano.model.dto;

import com.example.giallozafferano.model.entity.Categoria;
import lombok.Data;


public class RicettaDTO
{
    private Long id;
    private String name;
    private String ingrediente;
    private double tempCottura;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getTempCottura() {
        return tempCottura;
    }

    public void setTempCottura(double tempCottura) {
        this.tempCottura = tempCottura;
    }
}
