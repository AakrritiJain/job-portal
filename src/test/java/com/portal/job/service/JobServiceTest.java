package com.portal.job.service;

import com.portal.job.domain.Job;
import com.portal.job.repository.JobRepository;
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
public class JobServiceTest {

    @InjectMocks
    private JobService jobService;
    @Mock
    private JobRepository jobRepository;
    private Job job = new Job();

    @Test
    public void shouldSaveJob() {
        jobService.save(job);

        verify(jobRepository).save(same(job));
    }

    @Test
    public void shouldFindJobById() {
        job.setId(100);
        when(jobRepository.find(100)).thenReturn(job);

        Job response = jobService.find(100);

        verify(jobRepository).find(same(100));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldFindAllJobs() {
        when(jobRepository.findAll()).thenReturn(newArrayList(job));

        List<Job> response = jobService.findAll();

        verify(jobRepository).findAll();
        assertEquals(response.size(), 1);
    }
}
