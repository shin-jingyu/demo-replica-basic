package com.replica.simple.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Entity
public class PetPairEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @Column(name = "poster_image_url")
    private String posterImageUrl;

    @Column(name = "start_date")
    private Instant startDate;
    @Column(name = "end_date")
    private Instant endDate;
    @Column(name = "simple_address")
    private String simpleAddress;
    @Column(name = "detail_address")
    private String detailAddress;
    private String url;

    @Lob
    private String content;

    @Column(name = "map_url")
    private String mapUrl;

    @Column(name = "tel_number")
    private String telNumber;

    @Enumerated(EnumType.STRING)
    private PetPairStatus status;

    @Column(name = "created_at")
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Instant updatedAt;
}
