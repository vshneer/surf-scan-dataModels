package com.carmel.surfScan.dataModels.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue
    private int id;
    private String jobId;
    private String domain;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="jobType", referencedColumnName = "id")
    private JobType jobType;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="jobStatus", referencedColumnName = "id")
    private JobStatus jobStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "job", fetch = FetchType.EAGER)
    private Set<Observation> observations;

}
