package com.replica.simple.controller;

import com.replica.simple.controller.dto.PatPairWriteDto.CreateResponsePetPair;
import com.replica.simple.controller.dto.PatPairWriteDto.CreateRequestPetPair;
import com.replica.simple.controller.dto.PetPairReadDto;
import com.replica.simple.mapper.PetPairMapper;
import com.replica.simple.usecase.CreateUseCase;
import com.replica.simple.usecase.ReadOneUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/patPair")
@Slf4j
public class PatPairApi {
    private final PetPairMapper petPairMapper;

    private final CreateUseCase createUseCase;
    private final ReadOneUseCase readOneUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponsePetPair createPetPair(@RequestBody  CreateRequestPetPair petPair) {
        return petPairMapper.toDto(createUseCase.createPet(petPair));
    }

    @GetMapping("/{patPairId}")
    @ResponseStatus(HttpStatus.OK)
    public PetPairReadDto.PetPairRead getPetPair(@PathVariable("patPairId") Long id) {
        return petPairMapper.toReadDto(readOneUseCase.readOneUseCase(id));
    }
}
