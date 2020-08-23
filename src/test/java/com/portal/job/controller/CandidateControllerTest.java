package com.portal.job.controller;

import com.portal.job.domain.Candidate;
import com.portal.job.service.CandidateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CandidateControllerTest {
    @InjectMocks
    private CandidateController candidateController;
    @Mock
    private CandidateService candidateService;
    private Candidate candidate = new Candidate();

    @Test
    public void shouldPostCandidateWithId() {
        candidate.setId(100);

        Candidate response = candidateController.save(candidate);

        verify(candidateService).save(same(candidate));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldPostCandidateWithoutId() {
        Candidate response = candidateController.save(candidate);

        verify(candidateService).save(same(candidate));
        assertNotNull(response.getId());
    }

    @Test
    public void shouldPutCandidate() {
        Candidate response = candidateController.update(100, candidate);

        verify(candidateService).update(same(candidate));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldGetCandidateById() {
        candidate.setId(100);
        when(candidateService.find(100)).thenReturn(candidate);

        Candidate response = candidateController.get(100);

        verify(candidateService).find(same(100));
        assertEquals(response.getId(), 100);
    }
}
