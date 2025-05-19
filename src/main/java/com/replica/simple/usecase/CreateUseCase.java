package com.replica.simple.usecase;

import com.replica.simple.controller.dto.PatPairImageDto.CreatePatPairImage;
import com.replica.simple.controller.dto.PatPairWriteDto.CreateRequestPetPair;
import com.replica.simple.domain.PetPair;

import java.util.List;

public interface CreateUseCase {
    PetPair createPet(CreateRequestPetPair petPair, List<CreatePatPairImage> periImage);
}
