package com.replica.simple.usecase;

import com.replica.simple.controller.dto.PatPairWriteDto.CreateRequestPetPair;
import com.replica.simple.domain.PetPair;

public interface CreateUseCase {
    PetPair createPet(CreateRequestPetPair petPair);
}
