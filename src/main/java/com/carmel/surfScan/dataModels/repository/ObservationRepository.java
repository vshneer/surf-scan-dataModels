package com.carmel.surfScan.dataModels.repository;

import com.carmel.surfScan.dataModels.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<Observation, Integer> {
}
