package com.replica.simple.service;

import com.replica.simple.controller.dto.PatPairWriteDto.CreateRequestPetPair;
import com.replica.simple.domain.PetPair;
import com.replica.simple.domain.PetPairStatus;
import com.replica.simple.mapper.PetPairImageMapper;
import com.replica.simple.mapper.PetPairMapper;
import com.replica.simple.repository.PetPairRepository;
import com.replica.simple.usecase.CreateUseCase;
import com.replica.simple.usecase.ReadOneUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class PetPairService implements CreateUseCase, ReadOneUseCase {

    private final PetPairRepository petPairRepository;
    private final PetPairImageMapper petPairImageMapper;
    private final PetPairMapper petPairMapper;

    @Transactional
    @Override
    public PetPair createPet(CreateRequestPetPair petPair) {
        var petPairEntity = petPairMapper.toEntity(petPair);
        var petPairImage = petPair.images().stream()
                .map(petPairImageMapper::toEntity)
                .peek(img -> img.setPetPair(petPairEntity))
                .toList();

        petPairEntity.setStatus(PetPairStatus.ACTIVE);
        petPairEntity.setImages(petPairImage);

        return petPairMapper.toDomain(petPairRepository.save(petPairEntity));
    }

    @Transactional(readOnly = true)
    @Override
    public PetPair readOneUseCase(long id) {
        var petPair = petPairRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 PetPair를 찾을 수 없습니다."));

        return petPairMapper.toDomain(petPair);
    }
}
