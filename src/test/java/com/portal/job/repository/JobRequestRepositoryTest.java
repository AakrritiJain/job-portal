package com.portal.job.repository;

import com.portal.job.domain.JobRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static com.portal.job.repository.JobRequestRepository.SELECT_QUERY;
import static com.portal.job.repository.JobRequestRepository.UPDATE_QUERY;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JobRequestRepositoryTest {
    @InjectMocks
    private JobRequestRepository jobRequestRepository;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    private JobRequest jobRequest;

    @Before
    public void setup() {
        jobRequest = getJobRequest();
    }

    @Test
    public void shouldSaveJobRequest() {
        jobRequestRepository.save(jobRequest);

        verify(entityManager).persist(jobRequest);
    }

    @Test
    public void shouldUpdateJobRequest() {
        when(entityManager.createQuery(UPDATE_QUERY)).thenReturn(query);

        jobRequestRepository.update(jobRequest);

        verify(entityManager).createQuery(same(UPDATE_QUERY));
        verify(query).executeUpdate();
    }

    @Test
    public void shouldFindJobRequestById() {
        jobRequest.setId(100);
        when(entityManager.find(JobRequest.class, 100)).thenReturn(jobRequest);

        JobRequest response = jobRequestRepository.find(100);

        verify(entityManager).find(same(JobRequest.class), same(100));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldFindAllJobRequests() {
        when(entityManager.createQuery(SELECT_QUERY)).thenReturn(query);
        when(query.getResultList()).thenReturn(newArrayList(jobRequest));

        List<JobRequest> response = jobRequestRepository.findAll();

        verify(entityManager).createQuery(same(SELECT_QUERY));
        assertEquals(response.size(), 1);
    }

    private JobRequest getJobRequest() {
        JobRequest jobRequest = new JobRequest();
        jobRequest.setCandidateId(201);
        jobRequest.setJobId(301);
        return jobRequest;
    }
}
