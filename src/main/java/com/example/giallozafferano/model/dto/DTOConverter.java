package com.example.giallozafferano.model.dto;

import com.example.giallozafferano.model.entity.Categoria;
import com.example.giallozafferano.model.entity.Ricetta;
import org.springframework.stereotype.Service;

@Service
public class DTOConverter {

    public CategoriaDTO toDTO (Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setCategoria(categoria.getCategoria());
        return dto;
    }

    public Categoria fromDTO(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setCategoria(dto.getCategoria());
        return categoria;
    }

    public RicettaDTO toDTO (Ricetta ricetta) {
        RicettaDTO dto = new RicettaDTO();
        dto.setId(ricetta.getId());
        dto.setName(ricetta.getName());
        dto.setIngrediente(ricetta.getIngrediente());
        dto.setTempCottura(ricetta.getTempCottura());
        return dto;
    }

    public Ricetta fromDTO (RicettaDTO dto) {
        Ricetta ricetta = new Ricetta();
        ricetta.setName(dto.getName());
        ricetta.setIngrediente(dto.getIngrediente());
        ricetta.setTempCottura(dto.getTempCottura());
        ricetta.setCategoria(dto.getCategoria());
        return ricetta;
    }



}
