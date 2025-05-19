package com.replica.simple.controller;

import com.replica.simple.controller.dto.PatPairImageDto.CreatePatPairImage;
import com.replica.simple.controller.dto.PatPairWriteDto.CreateResponsePetPair;
import com.replica.simple.controller.dto.PatPairWriteDto.CreateRequestPetPair;
import com.replica.simple.mapper.PetPairImageMapper;
import com.replica.simple.mapper.PetPairMapper;
import com.replica.simple.usecase.CreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/patPair")
public class PatPairApi {
    private final PetPairMapper petPairMapper;
    private final PetPairImageMapper petPairImageMapper;

    private final CreateUseCase createUseCase;
//    private final ReadOneUseCase ReadOneUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponsePetPair createPetPair(@RequestBody  CreateRequestPetPair petPair, List<CreatePatPairImage> image) {
        return petPairMapper.toDto(createUseCase.createPet(petPair, image));
    }

}
