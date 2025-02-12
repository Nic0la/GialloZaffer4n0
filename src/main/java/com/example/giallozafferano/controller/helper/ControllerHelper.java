package com.example.giallozafferano.controller.helper;

import com.example.giallozafferano.model.dto.CategoriaDTO;
import com.example.giallozafferano.model.dto.RicettaDTO;
import com.example.giallozafferano.model.entity.Categoria;

import java.util.List;

public interface ControllerHelper
{
    //Ricetta
    //Lista:
    List<RicettaDTO> getallRicetta();
    //Trova la ricetta in base all'id:
    RicettaDTO getRicettaById(Long id);
    //Inserisci la ricetta nel db:
    RicettaDTO createRicetta(RicettaDTO ricetta);
    //Modifica la ricetta:
    RicettaDTO updateRicetta(RicettaDTO ricetta);
    //Cancella la ricetta:
    void deleteRicetta(Long id);
    //Lista di ricette per Categoria
    List<RicettaDTO> getRicettaByCategoria(Categoria categoria);
    //Trova Ricetta in base al nome:
    RicettaDTO getRicettaByName(String name);


    //Categoria
    List<CategoriaDTO> getallCategoria();
    CategoriaDTO getCategoriaById(Long id);
    CategoriaDTO createCategoria(CategoriaDTO categoria);
    CategoriaDTO updateCategoria(CategoriaDTO categoria);
    void deleteCategoria(Long id);
    CategoriaDTO getCategoriaByName(String name);

}
