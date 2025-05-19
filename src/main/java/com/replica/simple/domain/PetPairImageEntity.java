package com.replica.simple.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
@Table(name = "petPairImageEntity")
public class PetPairImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long petFairImageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_pair_id", nullable = false)
    private PetPairEntity petPair;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private int sortOrder;

    @CreatedDate
    private Instant createdAt;
}
