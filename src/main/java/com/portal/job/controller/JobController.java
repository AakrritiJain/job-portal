package com.portal.job.controller;

import com.portal.job.domain.Job;
import com.portal.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping(value = "/jobs")
    public Job save(@RequestBody Job job) {
        if (job.getId() == 0) {
            job.setId((int) (Math.random() * 5000) + 100);
        }
        jobService.save(job);
        return job;
    }

    @GetMapping(value = "/jobs/{id}")
    public Job get(@PathVariable("id") int id) {
        return jobService.find(id);
    }

    @GetMapping(value = "/jobs")
    public List<Job> getAll() {
        return jobService.findAll();
    }

}
