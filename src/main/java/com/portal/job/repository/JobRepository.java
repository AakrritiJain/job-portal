package com.portal.job.repository;

import com.portal.job.domain.Job;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JobRepository extends AbstractRepository {
    public void save(Job job) {
        getEntityManager().persist(job);
    }

    public List<Job> findAll() {
        return getEntityManager().createQuery("Select job from Job job").getResultList();
    }

    public Job find(int id) {
        return getEntityManager().find(Job.class, id);
    }
}
