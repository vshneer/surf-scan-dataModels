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
@Table(name = "JOB_TYPE_TBL")
public class JobType {
    @Id
    @GeneratedValue
    private int id;
    private String typeTitle;

}
