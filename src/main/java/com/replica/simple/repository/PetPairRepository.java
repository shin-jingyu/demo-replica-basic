package com.replica.simple.repository;

import com.replica.simple.domain.PetPairEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface PetPairRepository extends JpaRepository<PetPairEntity, Long>  {

}
