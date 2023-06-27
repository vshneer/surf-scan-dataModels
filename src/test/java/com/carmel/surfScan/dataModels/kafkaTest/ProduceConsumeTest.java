package com.carmel.surfScan.dataModels.kafkaTest;

import com.carmel.surfScan.dataModels.Utils;
import com.carmel.surfScan.dataModels.kafkaMessage.DomainJob;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@Sql(scripts = "/create-data.sql")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
@DirtiesContext
public class ProduceConsumeTest extends Utils {

    @Value(value = "${test.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, DomainJob> kafkaTemplate;

    @Autowired
    private KafkaDomainJobConsumer consumer;

    @Test
    void when_DOMAIN_JOB_PUBLISH_then_DATA_IS_AVAILABLE_FOR_CONSUMER() throws InterruptedException {
        kafkaTemplate.send(topic, new DomainJob(JOB_PRIMARY_ID, DOMAIN));
        // check if kafka has message
        boolean messageConsumed = consumer.getLatch()
                .await(10, TimeUnit.SECONDS);
        assertTrue(messageConsumed);
        assertEquals(consumer.getPayload().getDomain(), DOMAIN);
        assertEquals(consumer.getPayload().getJobPrimaryId(), JOB_PRIMARY_ID);
    }
}
