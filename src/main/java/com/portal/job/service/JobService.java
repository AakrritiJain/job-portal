package com.portal.job.service;

import com.portal.job.domain.Job;
import com.portal.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public void save(Job job) {
        jobRepository.save(job);
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job find(int id) {
        return jobRepository.find(id);
    }
}
