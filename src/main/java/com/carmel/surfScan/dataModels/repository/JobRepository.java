package com.carmel.surfScan.dataModels.repository;

import com.carmel.surfScan.dataModels.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
    Job findByJobId(String jobId);
}
