package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.UserTask;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateUserTaskRepository {

    private final SessionFactory sessionFactory;

    public HibernateUserTaskRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(UserTask userTask) {
        sessionFactory.getCurrentSession().save(userTask);
        return userTask.getId();
    }
}
