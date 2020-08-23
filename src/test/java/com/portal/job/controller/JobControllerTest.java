package com.portal.job.controller;

import com.portal.job.domain.Job;
import com.portal.job.service.JobService;
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
public class JobControllerTest {
    @InjectMocks
    private JobController jobController;
    @Mock
    private JobService jobService;
    private Job job = new Job();


    @Test
    public void shouldPostJobWithId() {
        job.setId(100);

        Job response = jobController.save(job);

        verify(jobService).save(same(job));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldPostJobWithoutId() {
        Job response = jobController.save(job);

        verify(jobService).save(same(job));
        assertNotNull(response.getId());
    }


    @Test
    public void shouldGetJobById() {
        job.setId(100);
        when(jobService.find(100)).thenReturn(job);

        Job response = jobController.get(100);

        verify(jobService).find(same(100));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldGetAllJobs() {
        job.setId(100);
        when(jobService.findAll()).thenReturn(newArrayList(job));

        List<Job> response = jobController.getAll();

        verify(jobService).findAll();
        assertEquals(response.size(), 1);
    }
}
