package com.carmel.surfScan.dataModels;

import com.carmel.surfScan.dataModels.entity.Job;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "/create-data.sql")
@DirtiesContext
public class JobEntityTest extends Utils{

    @Test
    void WHEN_JOB_SAVED_THEN_FINDS_BY_JOB_ID(){
        createJob();
        Job job = jobRepository.findByJobId(JOB_ID);
        assertAll(
                () -> assertNotNull(job),
                () -> assertEquals(job.getJobId(), JOB_ID),
                () -> assertEquals(job.getJobStatus().getStatusTitle(), INITIAL_JOB_STATUS),
                () -> assertEquals(job.getJobType().getTypeTitle(), JOB_TYPE),
                () -> assertEquals(job.getDomain(), DOMAIN),
                () -> assertTrue(job.getObservations().isEmpty())
        );
    }
}
