package com.replica.simple.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatPairImage {
    private long petFairImageId;
    private PetPairEntity petPair;
    private String imageUrl;
    private int sortOrder;
}
