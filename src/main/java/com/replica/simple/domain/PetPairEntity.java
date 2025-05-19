package com.replica.simple.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "petPair")
@Getter
@Setter
public class PetPairEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long petFairId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String posterImageUrl;

    @Column(nullable = false)
    private Instant startDate;

    @Column(nullable = false)
    private Instant endDate;

    @Column(nullable = false)
    private String simpleAddress;

    @Column(nullable = false)
    private String detailAddress;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    @Lob
    private String content;

    @Column(nullable = false)
    private String mapUrl;

    @Column(nullable = false)
    private String telNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PetPairStatus status;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    @OneToMany(mappedBy = "petPair", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PetPairImageEntity> images = new ArrayList<>();
}
