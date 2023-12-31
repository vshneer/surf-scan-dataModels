package com.carmel.surfScan.dataModels;

import com.carmel.surfScan.dataModels.entity.Job;
import com.carmel.surfScan.dataModels.repository.JobRepository;
import com.carmel.surfScan.dataModels.repository.JobStatusRepository;
import com.carmel.surfScan.dataModels.repository.JobTypeRepository;
import com.carmel.surfScan.dataModels.repository.ObservationRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class Utils {
    protected static String JOB_ID = "jobId";
    protected static String DOMAIN = "example.com";
    protected static String JOB_TYPE = "ping";
    protected static String INITIAL_JOB_STATUS = "submitted";
    protected static String SAMPLE_OBSERVATION = "Host is UNREACHABLE";
    protected static final int JOB_PRIMARY_ID = 1;

    @Autowired
    protected JobRepository jobRepository;

    @Autowired
    protected JobTypeRepository jobTypeRepository;

    @Autowired
    protected JobStatusRepository jobStatusRepository;

    @Autowired
    protected ObservationRepository observationRepository;


    protected int createJob(){
        Job job = new Job();
        job.setJobId(JOB_ID);
        job.setDomain(DOMAIN);
        job.setJobType(jobTypeRepository.findByTypeTitle(JOB_TYPE));
        job.setJobStatus(jobStatusRepository.findByStatusTitle(INITIAL_JOB_STATUS));
        jobRepository.save(job);
        return job.getId();
    }
}
