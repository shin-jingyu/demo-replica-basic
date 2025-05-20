package com.replica.simple.controller.dto;

import com.replica.simple.controller.dto.PatPairImageDto.ResponsePatPairImage;
import com.replica.simple.domain.PetPairStatus;

import java.time.Instant;
import java.util.List;

public class PetPairReadDto {

    private PetPairReadDto() {}

    public record PetPairRead(
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
            String telNumber,
            PetPairStatus status,
            Instant createdAt,
            Instant updatedAt,
            List<ResponsePatPairImage>images
    ) {}
}
