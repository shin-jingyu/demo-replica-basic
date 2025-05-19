package com.replica.simple.controller.dto;

import com.replica.simple.domain.PatPairImage;
import com.replica.simple.domain.PetPair;
import com.replica.simple.domain.PetPairStatus;

import java.time.Instant;

public class PatPairWriteDto {

    private PatPairWriteDto() {}

    public record CreateRequestPetPair(
            Long petFairId,
            String title,
            String posterImageUrl,
            Instant startDate,
            Instant endDate,
            String simpleAddress,
            String detailAddress,
            String url,
            String content,
            String mapUrl,
            String telNumber
    ) {}

    public record CreateResponsePetPair(
            PetPair petPair
    ) {}
}
