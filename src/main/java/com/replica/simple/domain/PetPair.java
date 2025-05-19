package com.replica.simple.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor
public class PetPair {

    private Long petFairId;
    private String title;
    private String posterImageUrl;
    private Instant startDate;
    private Instant endDate;
    private String simpleAddress;
    private String detailAddress;
    private String url;
    private String content;
    private String mapUrl;
    private String telNumber;
    private PetPairStatus status;
    private Instant createdAt;
    private Instant updatedAt;
    private List<PatPairImage> images ;
}
