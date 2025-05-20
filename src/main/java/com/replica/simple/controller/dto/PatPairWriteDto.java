package com.replica.simple.controller.dto;

import com.replica.simple.controller.dto.PatPairImageDto.ResponsePatPairImage;

import java.time.Instant;
import java.util.List;

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
            String telNumber,
            List<ResponsePatPairImage> images
    ) {}

    public record CreateResponsePetPair(
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
            List<ResponsePatPairImage> images
    ) {}
}
