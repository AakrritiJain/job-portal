package com.portal.job.service;

import com.portal.job.domain.JobRequest;
import com.portal.job.repository.JobRequestRepository;
import org.junit.Before;
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
public class JobRequestServiceTest {
    @InjectMocks
    private JobRequestService jobRequestService;
    @Mock
    private JobRequestRepository jobRequestRepository;
    private JobRequest jobRequest;

    @Before
    public void setup() {
        jobRequest = getJobRequest();
    }

    @Test
    public void shouldSaveJobRequest() {
        jobRequestService.save(jobRequest);

        verify(jobRequestRepository).save(same(jobRequest));
    }

    @Test
    public void shouldUpdateJobRequest() {
        jobRequestService.update(jobRequest);

        verify(jobRequestRepository).update(same(jobRequest));
    }

    @Test
    public void shouldFindJobRequestById() {
        jobRequest.setId(100);
        when(jobRequestRepository.find(100)).thenReturn(jobRequest);

        JobRequest response = jobRequestService.find(100);

        verify(jobRequestRepository).find(same(100));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldFindAllJobRequests() {
        when(jobRequestRepository.findAll()).thenReturn(newArrayList(jobRequest));

        List<JobRequest> response = jobRequestService.findAll();

        verify(jobRequestRepository).findAll();
        assertEquals(response.size(), 1);
    }

    private JobRequest getJobRequest() {
        JobRequest jobRequest = new JobRequest();
        jobRequest.setCandidateId(201);
        jobRequest.setJobId(301);
        return jobRequest;
    }
}
