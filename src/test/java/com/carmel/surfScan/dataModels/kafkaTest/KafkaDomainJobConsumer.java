package com.carmel.surfScan.dataModels.kafkaTest;

import com.carmel.surfScan.dataModels.kafkaMessage.DomainJob;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class KafkaDomainJobConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDomainJobConsumer.class);

    private CountDownLatch latch = new CountDownLatch(1);
    private DomainJob payload;

    @KafkaListener(topics = "${test.topic}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(DomainJob domainJob) {
        LOGGER.info("received payload='{}'", domainJob);
        payload = domainJob;
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void resetLatch() {
        latch = new CountDownLatch(1);
    }

    public DomainJob getPayload() {
        return payload;
    }


}