package com.carmel.surfScan.dataModels;

import com.carmel.surfScan.dataModels.entity.JobStatus;
import com.carmel.surfScan.dataModels.entity.JobType;
import com.carmel.surfScan.dataModels.repository.JobStatusRepository;
import com.carmel.surfScan.dataModels.repository.JobTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Sql(scripts = "/create-data.sql")
@DirtiesContext
public class PopulateDBTest{

    @Autowired
    JobStatusRepository jobStatusRepository;

    @Autowired
    JobTypeRepository jobTypeRepository;

    @Test
    void WHEN_INIT_SCRIPT_THEN_TYPE_AND_STATUS_REACHABLE(){
        JobStatus submitted = jobStatusRepository.findByStatusTitle("submitted");
        JobStatus running = jobStatusRepository.findByStatusTitle("running");
        JobStatus finished = jobStatusRepository.findByStatusTitle("finished");

        JobType ping = jobTypeRepository.findByTypeTitle("ping");
        JobType subdomain = jobTypeRepository.findByTypeTitle("subdomain");

        assertAll(
                () -> assertNotNull(submitted),
                () -> assertNotNull(running),
                () -> assertNotNull(finished),
                () -> assertNotNull(ping),
                () -> assertNotNull(subdomain)
        );

    }
}
