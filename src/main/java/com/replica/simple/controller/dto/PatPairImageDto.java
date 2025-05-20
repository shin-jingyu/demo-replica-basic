package com.replica.simple.controller.dto;

public class PatPairImageDto {

    private PatPairImageDto() {}

    public record ResponsePatPairImage(
            String imageUrl,
            int sortOrder
    ) {}
}
