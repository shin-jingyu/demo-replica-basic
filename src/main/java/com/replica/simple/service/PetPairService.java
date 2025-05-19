package com.replica.simple.service;

import com.replica.simple.controller.dto.PatPairImageDto.CreatePatPairImage;
import com.replica.simple.controller.dto.PatPairWriteDto.CreateRequestPetPair;
import com.replica.simple.domain.PetPair;
import com.replica.simple.mapper.PetPairImageMapper;
import com.replica.simple.mapper.PetPairMapper;
import com.replica.simple.repository.PetPairRepository;
import com.replica.simple.usecase.CreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetPairService implements CreateUseCase {

    private final PetPairRepository petPairRepository;
    private final PetPairImageMapper petPairImageMapper;
    private final PetPairMapper petPairMapper;


    @Override
    public PetPair createPet(CreateRequestPetPair petPair, List<CreatePatPairImage> periImage) {
        var petPairEntity = petPairMapper.toEntity(petPair);
        var petPairImage = periImage.stream()
                .map(petPairImageMapper::toEntity).toList();
        petPairEntity.setImages(petPairImage);

        return petPairMapper.toDomain(petPairRepository.save(petPairEntity));
    }
}
