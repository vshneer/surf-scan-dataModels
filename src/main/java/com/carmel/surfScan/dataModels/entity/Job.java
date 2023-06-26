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

    @Column(unique=true)
    private String jobId;
    private String domain;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="jobType", referencedColumnName = "id")
    private JobType jobType; // TODO good candidate to for cache

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="jobStatus", referencedColumnName = "id")
    private JobStatus jobStatus; // TODO good candidate to for cache

    @JsonIgnore
    @OneToMany(mappedBy = "job", fetch = FetchType.EAGER)
    private Set<Observation> observations;

}
