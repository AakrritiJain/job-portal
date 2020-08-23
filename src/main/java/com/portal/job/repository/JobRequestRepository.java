package com.portal.job.repository;

import com.portal.job.domain.JobRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class JobRequestRepository extends AbstractRepository {
    public final static String SELECT_QUERY = "Select jr from JobRequest jr";
    public final static String UPDATE_QUERY = "UPDATE JobRequest jr SET jr.status = :status WHERE jr.id = :id";

    public void save(JobRequest jobRequest) {
        getEntityManager().persist(jobRequest);
    }

    public JobRequest find(int id) {
        return getEntityManager().find(JobRequest.class, id);
    }

    public List<JobRequest> findAll() {
        return getEntityManager().createQuery(SELECT_QUERY).getResultList();
    }

    public void update(JobRequest jobRequest) {
        Query query = getEntityManager().createQuery(UPDATE_QUERY);
        query.setParameter("id", jobRequest.getId());
        query.setParameter("status", jobRequest.getStatus());
        query.executeUpdate();
    }

}
