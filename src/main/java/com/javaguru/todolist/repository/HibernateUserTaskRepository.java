package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.domain.UserTask;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Task> findAllTasksByUserId(Long userId) {
        return sessionFactory.getCurrentSession().createQuery("select t from UserTask ut, Task t join ut.user u where u.id = :userId")
                .setParameter("userId", userId)
                .list();
    }
}
