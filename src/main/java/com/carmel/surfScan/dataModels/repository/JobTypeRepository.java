package com.carmel.surfScan.dataModels.repository;


import com.carmel.surfScan.dataModels.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType, Integer> {
    JobType findByTypeTitle(String title);
}
