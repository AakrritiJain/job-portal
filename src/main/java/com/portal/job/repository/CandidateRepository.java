package com.portal.job.repository;

import com.portal.job.domain.Candidate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CandidateRepository extends AbstractRepository {
    public final static String SELECT_QUERY = "Select c from Candidate c";

    public Candidate find(int id) {
        return getEntityManager().find(Candidate.class, id);
    }

    public List<Candidate> findAll() {
        return getEntityManager().createQuery(SELECT_QUERY).getResultList();
    }

    public void update(Candidate candidate) {
        getEntityManager().merge(candidate);
    }

    public void save(Candidate candidate) {
        persist(candidate);
    }

    public void remove(Candidate candidate) {
        remove(candidate);
    }
}
