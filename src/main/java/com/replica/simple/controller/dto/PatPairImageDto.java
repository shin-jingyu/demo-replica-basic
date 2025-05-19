package com.replica.simple.controller.dto;

public class PatPairImageDto {

    private PatPairImageDto() {}

    public record ReadPatPairImage(
             long petFairImageId,
             String imageUrl,
             int sortOrder
    ) {}

    public record CreatePatPairImage(
            long petFairImageId,
            String imageUrl,
            int sortOrder
    ) {}
}
