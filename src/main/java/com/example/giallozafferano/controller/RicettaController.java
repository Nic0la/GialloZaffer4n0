package com.example.giallozafferano.controller;

import com.example.giallozafferano.controller.helper.ControllerHelperImp;
import com.example.giallozafferano.model.dto.RicettaDTO;
import com.example.giallozafferano.model.dto.RicettaListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ricette")
public class RicettaController {

    @Autowired
    ControllerHelperImp ch;


    @GetMapping
    public RicettaListDTO getAllRicette(){
        RicettaListDTO ricettaList = new RicettaListDTO();
        ricettaList.setRicettaList(ch.getallRicetta());
        return ricettaList;
    }

    @GetMapping("/by-name/{name}")
    public RicettaDTO getRicettaByName(@PathVariable String name){
        RicettaListDTO ricettaList = new RicettaListDTO();
        ricettaList.setRicettaList(ch.getallRicetta());
        for(RicettaDTO ricetta : ricettaList.getRicettaList()){
            if(ricetta.getName().equals(name))
                return ricetta;
        }

        return ch.getRicettaByName(name);
    }

    @GetMapping("/{id}")
    public RicettaDTO getRicetta(@PathVariable Long id){
        return ch.getRicettaById(id);
    }

    @PostMapping
    public void saveRicetta(@RequestBody RicettaDTO dto){
        ch.createRicetta(dto);
    }

    @DeleteMapping("/{id}")
    public Long deleteRicetta(@PathVariable Long id){
        return id;
    }

}
