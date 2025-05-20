package com.replica.simple.mapper;

import com.replica.simple.controller.dto.PatPairImageDto.ResponsePatPairImage;
import com.replica.simple.domain.PatPairImage;
import com.replica.simple.domain.PetPairImageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetPairImageMapper {
    ResponsePatPairImage toDto(PatPairImage patPairImage);
    PetPairImageEntity toEntity(ResponsePatPairImage createPatPairImage);
    PatPairImage toDomain(PetPairImageEntity entity);
}
