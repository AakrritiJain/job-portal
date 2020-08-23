package com.portal.job.service;

import com.portal.job.domain.Candidate;
import com.portal.job.repository.CandidateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceTest {
    @InjectMocks
    private CandidateService candidateService;
    @Mock
    private CandidateRepository candidateRepository;
    private Candidate candidate = new Candidate();

    @Test
    public void shouldSaveCandidate() {
        candidateService.save(candidate);

        verify(candidateRepository).save(same(candidate));
    }

    @Test
    public void shouldUpdateCandidate() {
        candidateService.update(candidate);

        verify(candidateRepository).update(same(candidate));
    }

    @Test
    public void shouldFindCandidateById() {
        candidate.setId(100);
        when(candidateRepository.find(100)).thenReturn(candidate);

        Candidate response = candidateService.find(100);

        verify(candidateRepository).find(same(100));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldFindAllCandidates() {
        when(candidateRepository.findAll()).thenReturn(newArrayList(candidate));

        List<Candidate> response = candidateService.findAll();

        verify(candidateRepository).findAll();
        assertEquals(response.size(), 1);
    }
}
