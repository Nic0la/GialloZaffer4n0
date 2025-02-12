package com.example.giallozafferano.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Entity
public class Ricetta extends BaseEntity {

    private String name;
    private String ingrediente;
    private Double tempCottura;



    @ManyToOne
    @JoinColumn(name="categoria_id", nullable = true)
    private Categoria categoria;

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

    public Double getTempCottura() {
        return tempCottura;
    }

    public void setTempCottura(Double tempCottura) {
        this.tempCottura = tempCottura;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
