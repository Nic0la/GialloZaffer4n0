package com.example.giallozafferano.model.mapper;

import com.example.giallozafferano.model.dto.RicettaDTO;
import com.example.giallozafferano.model.entity.Ricetta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RicettaMapper {

    RicettaMapper INSTANCE = Mappers.getMapper(RicettaMapper.class);

    @Mapping(source="tempCottura", target = "tempCottura")
    RicettaDTO ricettaToRicettaDto(Ricetta ricetta);
}
