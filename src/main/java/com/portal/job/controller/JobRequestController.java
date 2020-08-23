package com.portal.job.controller;

import com.portal.job.domain.JobRequest;
import com.portal.job.service.JobRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRequestController {
    @Autowired
    private JobRequestService jobRequestService;

    @PostMapping(value = "/job-requests")
    public JobRequest save(@RequestBody JobRequest jobRequest) {
        if (jobRequest.getId() == 0) {
            jobRequest.setId((int) (Math.random() * 7000) + 100);
        }
        jobRequestService.save(jobRequest);
        return jobRequest;
    }

    @PutMapping(value = "/job-requests/{id}")
    public JobRequest update(@PathVariable int id,
                             @RequestBody JobRequest jobRequest) {
        jobRequest.setId(id);
        jobRequestService.update(jobRequest);
        return jobRequest;
    }

    @GetMapping(value = "/job-requests/{id}")
    public JobRequest get(@PathVariable("id") int id) {
        return jobRequestService.find(id);
    }

    @GetMapping(value = "/job-requests")
    public List<JobRequest> getAll() {
        return jobRequestService.findAll();
    }

}
