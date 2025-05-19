package com.replica.simple.mapper;

import com.replica.simple.controller.dto.PatPairImageDto.CreatePatPairImage;
import com.replica.simple.controller.dto.PatPairImageDto.ReadPatPairImage;
import com.replica.simple.domain.PetPairImageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetPairImageMapper {
    ReadPatPairImage toDto(PetPairImageEntity petPairImageEntity);
    PetPairImageEntity toEntity(CreatePatPairImage readPatPeriImage);
}
