package com.carmel.surfScan.dataModels.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "JOB_STATUS_TBL")
public class JobStatus {
    @Id
    @GeneratedValue
    private int id;
    private String statusTitle;

}

