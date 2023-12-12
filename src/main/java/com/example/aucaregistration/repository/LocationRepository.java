package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.StopLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<StopLocation, Integer> {}