package com.carmel.surfScan.dataModels.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Observation {
    @Id
    @GeneratedValue
    private int id;

    String observation;

    @JoinColumn(name = "job", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Job.class, fetch = FetchType.LAZY)
    private Job job;

    @Column(name = "job")
    private long jobId;

}
