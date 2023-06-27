package com.carmel.surfScan.dataModels.kafkaMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomainJob {
    Integer jobPrimaryId;
    String domain;
}
