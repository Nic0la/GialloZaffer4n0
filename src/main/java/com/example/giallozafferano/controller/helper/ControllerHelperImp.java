package com.example.giallozafferano.controller.helper;

import com.example.giallozafferano.model.dto.CategoriaDTO;
import com.example.giallozafferano.model.dto.DTOConverter;
import com.example.giallozafferano.model.dto.RicettaDTO;
import com.example.giallozafferano.model.entity.Categoria;
import com.example.giallozafferano.model.entity.Ricetta;
import com.example.giallozafferano.controller.helper.ControllerHelper;
import com.example.giallozafferano.repository.CategoriaRepository;
import com.example.giallozafferano.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ControllerHelperImp implements ControllerHelper {

    @Autowired
    DTOConverter converter;

    @Autowired
    RicettaRepository rRepo;

    @Autowired
    CategoriaRepository cRepo;

    @Override
    public List<RicettaDTO> getallRicetta() {
        List<Ricetta> all = rRepo.findAll();
        List<RicettaDTO> ricettaListDTOs = new ArrayList<>();
        for(Ricetta ricetta : all){
            ricettaListDTOs.add(converter.toDTO(ricetta));
        }
        return ricettaListDTOs;
    }

    @Override
    public RicettaDTO getRicettaById(Long id) {
        Optional<Ricetta> batch= rRepo.findById(id);
        if(batch.isPresent())
            return converter.toDTO(batch.get());
        return null;
    }

    @Override
    public RicettaDTO createRicetta(RicettaDTO ricetta) {
        Ricetta entity = converter.fromDTO(ricetta);
        entity = rRepo.save(entity);
        return converter.toDTO(entity);
    }

    @Override
    public RicettaDTO updateRicetta(RicettaDTO ricetta) {
        return null;
    }

    @Override
    public void deleteRicetta(Long id) {
    }

    @Override
    public List<RicettaDTO> getRicettaByCategoria(Categoria categoria) {
        List<Ricetta> all = rRepo.findAll();
        List<RicettaDTO> ricettaListDTOs = new ArrayList<>();
        for(Ricetta ricetta : all){
            if(ricetta.getCategoria().equals(categoria)){
                ricettaListDTOs.add(converter.toDTO(ricetta));
            }
        }
        return ricettaListDTOs;
    }

    @Override
    public RicettaDTO getRicettaByName(String name) {
        Ricetta batch = rRepo.findByName(name);
        return converter.toDTO(batch);
       
    }

    @Override
    public List<CategoriaDTO> getallCategoria() {
        List<Categoria> all = cRepo.findAll();
        List<CategoriaDTO> categoriaListDTOs = new ArrayList<>();
        for(Categoria categoria : all){
            categoriaListDTOs.add(converter.toDTO(categoria));
        }
        return categoriaListDTOs;
    }

    @Override
    public CategoriaDTO getCategoriaById(Long id) {
        Optional<Categoria> batch = cRepo.findById(id);
        if(batch.isPresent())
            return converter.toDTO(batch.get());
        return null;
    }

    @Override
    public CategoriaDTO createCategoria(CategoriaDTO categoria) {
        Categoria entity = converter.fromDTO(categoria);
        entity = cRepo.save(entity);
        return converter.toDTO(entity);
    }

    @Override
    public CategoriaDTO updateCategoria(CategoriaDTO categoria) {
        return null;
    }

    @Override
    public void deleteCategoria(Long id) {
    }

    @Override
    public CategoriaDTO getCategoriaByName(String name) {
        Categoria batch = cRepo.findByCategoria(name);
        return converter.toDTO(batch);
    }
}
