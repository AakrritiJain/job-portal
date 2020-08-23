package com.portal.job.repository;

import com.portal.job.domain.Job;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static com.portal.job.repository.JobRepository.SELECT_QUERY;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JobRepositoryTest {
    @InjectMocks
    private JobRepository jobRepository;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    private Job job = new Job();

    @Test
    public void shouldSaveJob() {
        jobRepository.save(job);

        verify(entityManager).persist(job);
    }

    @Test
    public void shouldFindJobById() {
        job.setId(100);
        when(entityManager.find(Job.class, 100)).thenReturn(job);

        Job response = jobRepository.find(100);

        verify(entityManager).find(same(Job.class), same(100));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldFindAllJobs() {
        when(entityManager.createQuery(SELECT_QUERY)).thenReturn(query);
        when(query.getResultList()).thenReturn(newArrayList(job));

        List<Job> response = jobRepository.findAll();

        verify(entityManager).createQuery(same(SELECT_QUERY));
        assertEquals(response.size(), 1);
    }
}
