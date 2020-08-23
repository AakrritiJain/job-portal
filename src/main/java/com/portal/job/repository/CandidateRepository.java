package com.portal.job.repository;

import com.portal.job.domain.Candidate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class CandidateRepository extends AbstractRepository {

    public Candidate find(int id) {
        return getEntityManager().find(Candidate.class, id);
    }

    public List<Candidate> findAll() {
        return getEntityManager().createQuery("Select c from Candidate c").getResultList();
    }

    public void update(Candidate candidate) {
        Query query = getEntityManager().createQuery("UPDATE Candidate c SET "
                + "c.firstName = :firstName,"
                + "c.lastName = :lastName,"
                + "c.skills = :skills,"
                + "c.headline = :headline,"
                + "c.experienceInYears = :experienceInYears,"
                + "c.email = :email,"
                + "c.contact = :contact "
                + "WHERE c.id = :id");
        query.setParameter("firstName", candidate.getFirstName());
        query.setParameter("lastName", candidate.getLastName());
        query.setParameter("skills", candidate.getSkills());
        query.setParameter("experienceInYears", candidate.getExperienceInYears());
        query.setParameter("headline", candidate.getHeadline());
        query.setParameter("contact", candidate.getContact());
        query.setParameter("email", candidate.getEmail());
        query.setParameter("id", candidate.getId());
        query.executeUpdate();
    }

    public void save(Candidate candidate) {
        persist(candidate);
    }

    public void remove(Candidate candidate) {
        remove(candidate);
    }
}
