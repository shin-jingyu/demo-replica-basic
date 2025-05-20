package com.replica.simple.mapper;

import com.replica.simple.controller.dto.PatPairWriteDto.CreateRequestPetPair;
import com.replica.simple.controller.dto.PatPairWriteDto.CreateResponsePetPair;
import com.replica.simple.controller.dto.PetPairReadDto.PetPairRead;
import com.replica.simple.domain.PetPair;
import com.replica.simple.domain.PetPairEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PetPairImageMapper.class)
public interface PetPairMapper {
    CreateResponsePetPair toDto(PetPair petPair);
    PetPair toDomain(PetPairEntity petPairEntity);
    PetPairEntity toEntity(CreateRequestPetPair createPetPair);
    PetPairRead toReadDto(PetPair PetPair);
}
