package com.portal.job.controller;

import com.portal.job.domain.Candidate;
import com.portal.job.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping(
            value = "/candidates"
    )
    public Candidate save(@RequestBody Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId((int) (Math.random() * 500) + 1);
        }
        candidateService.save(candidate);
        return candidate;
    }

    @PutMapping(value = "/candidates/{id}")
    public Candidate update(@PathVariable int id,
                            @RequestBody Candidate candidate) {
        candidate.setId(id);
        candidateService.update(candidate);
        return candidate;
    }

    @GetMapping(value = "/candidates/{id}")
    public Candidate get(@PathVariable("id") int id) {
        return candidateService.find(id);
    }

    @GetMapping(value = "/candidates")
    public List<Candidate> get() {
        return candidateService.findAll();
    }

}
