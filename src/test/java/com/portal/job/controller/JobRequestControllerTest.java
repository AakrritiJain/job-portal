package com.portal.job.controller;

import com.portal.job.domain.JobRequest;
import com.portal.job.service.JobRequestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JobRequestControllerTest {
    @InjectMocks
    private JobRequestController jobRequestController;
    @Mock
    private JobRequestService jobRequestService;
    private JobRequest jobRequest;

    @Before
    public void setup() {
        jobRequest = getJobRequest();
    }

    @Test
    public void shouldPostJobRequestWithId() {
        jobRequest.setId(100);

        JobRequest response = jobRequestController.save(jobRequest);

        verify(jobRequestService).save(same(jobRequest));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldPostJobRequestWithoutId() {
        JobRequest response = jobRequestController.save(jobRequest);

        verify(jobRequestService).save(same(jobRequest));
        assertNotNull(response.getId());
    }

    @Test
    public void shouldPutJobRequest() {
        JobRequest response = jobRequestController.update(100, jobRequest);

        verify(jobRequestService).update(same(jobRequest));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldGetJobRequestById() {
        jobRequest.setId(100);
        when(jobRequestService.find(100)).thenReturn(jobRequest);

        JobRequest response = jobRequestController.get(100);

        verify(jobRequestService).find(same(100));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldGetAllJobRequests() {
        jobRequest.setId(100);
        when(jobRequestService.findAll()).thenReturn(newArrayList(jobRequest));

        List<JobRequest> response = jobRequestController.getAll();

        verify(jobRequestService).findAll();
        assertEquals(response.size(), 1);
    }

    private JobRequest getJobRequest() {
        JobRequest jobRequest = new JobRequest();
        jobRequest.setCandidateId(201);
        jobRequest.setJobId(301);
        return jobRequest;
    }
}
