package com.carmel.surfScan.dataModels;

import com.carmel.surfScan.dataModels.repository.JobRepository;
import com.carmel.surfScan.dataModels.repository.JobStatusRepository;
import com.carmel.surfScan.dataModels.repository.JobTypeRepository;
import com.carmel.surfScan.dataModels.repository.ObservationRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class RepositoryContextTest {
    @Autowired
    private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private JobRepository jobRepository;
    @Autowired private JobStatusRepository jobStatusRepository;
    @Autowired private JobTypeRepository jobTypeRepository;
    @Autowired private ObservationRepository observationRepository;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(jobRepository).isNotNull();
        assertThat(jobStatusRepository).isNotNull();
        assertThat(jobTypeRepository).isNotNull();
        assertThat(observationRepository).isNotNull();
    }
}
