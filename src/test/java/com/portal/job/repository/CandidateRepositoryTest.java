package com.portal.job.repository;

import com.portal.job.domain.Candidate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static com.portal.job.repository.CandidateRepository.SELECT_QUERY;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CandidateRepositoryTest {

    @InjectMocks
    private CandidateRepository candidateRepository;
    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    private Candidate candidate = new Candidate();

    @Test
    public void shouldSaveCandidate() {
        candidateRepository.save(candidate);

        verify(entityManager).persist(candidate);
    }

    @Test
    public void shouldUpdateCandidate() {
        candidateRepository.update(candidate);

        verify(entityManager).merge(candidate);
    }

    @Test
    public void shouldFindCandidateById() {
        candidate.setId(100);
        when(entityManager.find(Candidate.class, 100)).thenReturn(candidate);

        Candidate response = candidateRepository.find(100);

        verify(entityManager).find(same(Candidate.class), same(100));
        assertEquals(response.getId(), 100);
    }

    @Test
    public void shouldFindAllCandidates() {
        when(entityManager.createQuery(SELECT_QUERY)).thenReturn(query);
        when(query.getResultList()).thenReturn(newArrayList(candidate));

        List<Candidate> response = candidateRepository.findAll();

        verify(entityManager).createQuery(same(SELECT_QUERY));
        assertEquals(response.size(), 1);
    }
}
