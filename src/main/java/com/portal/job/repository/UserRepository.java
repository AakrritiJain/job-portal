package com.portal.job.repository;

import com.portal.job.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserRepository extends AbstractRepository {

    public User find(String username) {
        return getEntityManager().find(User.class, username);
    }

    public void save(User user) {
        persist(user);
    }

    public void merge(User user) {
        merge(user);
    }

    public void remove(User user) {
        remove(user);
    }
}
