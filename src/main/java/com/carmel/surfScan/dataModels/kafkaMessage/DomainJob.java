package com.carmel.surfScan.dataModels.kafkaMessage;

import lombok.Data;

@Data
public class DomainJob {
    String jobId;
    String domain;
}
