package com.portal.job.service;

import com.portal.job.domain.Candidate;
import com.portal.job.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public void update(Candidate candidate) {
        candidateRepository.update(candidate);
    }

    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public Candidate find(int id) {
        return candidateRepository.find(id);
    }

    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }
}
