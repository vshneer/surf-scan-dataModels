package com.carmel.surfScan.dataModels;

import com.carmel.surfScan.dataModels.entity.Job;
import com.carmel.surfScan.dataModels.entity.Observation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "/create-data.sql")
@DirtiesContext
public class ObservationEntityTest extends Utils{

    @Test
    void GIVEN_JOB_WHEN_ADD_OBSERVATION_THEN_READ_OBSERVATION_FROM_JOB(){
        int jobPrimaryId = createJob();
        addObservation(jobPrimaryId);
        Job job = jobRepository.findByJobId(JOB_ID);
        assertAll(
                () -> assertFalse(job.getObservations().isEmpty()),
                () -> assertEquals(
                        job.getObservations()
                                .stream()
                                .findFirst()
                                .get()
                                .getObservation()
                        , SAMPLE_OBSERVATION)
        );
    }

    private void addObservation(int jobPrimaryId){
        Observation observation = new Observation();
        observation.setObservation(SAMPLE_OBSERVATION);
        observation.setJobId(jobPrimaryId);
        observationRepository.save(observation);
    }
}
