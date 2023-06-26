package com.carmel.surfScan.dataModels.kafkaMessage;

import lombok.Data;

@Data
public class DomainJob {
    Integer jobPrimaryId;
    String domain;
}
