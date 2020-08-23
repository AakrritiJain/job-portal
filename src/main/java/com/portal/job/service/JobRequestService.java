package com.portal.job.service;

import com.portal.job.domain.JobRequest;
import com.portal.job.repository.JobRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobRequestService {
    @Autowired
    private JobRequestRepository jobRequestRepository;

    public void save(JobRequest jobRequest) {
        jobRequestRepository.save(jobRequest);
    }

    public JobRequest find(int id) {
        return jobRequestRepository.find(id);
    }

    public List<JobRequest> findAll() {
        return jobRequestRepository.findAll();
    }

    public void update(JobRequest jobRequest) {
        jobRequestRepository.update(jobRequest);
    }
}
