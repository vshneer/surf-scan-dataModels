package com.carmel.surfScan.dataModels.repository;


import com.carmel.surfScan.dataModels.entity.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobStatusRepository extends JpaRepository<JobStatus, Integer> {
    JobStatus findByStatusTitle(String title);
}
