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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="job", referencedColumnName = "id")
    private Job job;
}
