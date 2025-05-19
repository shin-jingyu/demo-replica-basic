package com.replica.simple.controller.dto;

import com.replica.simple.domain.PetPair;

public class PetPairReadDto {

    private PetPairReadDto() {}

    public record PetPairRead(
            PetPair petPair
    ) {}
}
