package com.portal.job.repository;

import com.portal.job.domain.JobRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class JobRequestRepository extends AbstractRepository {
    public void save(JobRequest jobRequest) {
        getEntityManager().persist(jobRequest);
    }

    public JobRequest find(int id) {
        return getEntityManager().find(JobRequest.class, id);
    }

    public List<JobRequest> findAll() {
        return getEntityManager().createQuery("Select jr from JobRequest jr").getResultList();
    }

    public void update(JobRequest jobRequest) {
        Query query = getEntityManager().createQuery("UPDATE JobRequest jr SET "
                + "jr.status = :status "
                + "WHERE jr.id = :id");
        query.setParameter("id", jobRequest.getId());
        query.setParameter("status", jobRequest.getStatus());
        query.executeUpdate();
    }

}
