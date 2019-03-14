package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.Task;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("hibernate")
@Transactional
class HibernateTaskRepository implements TaskRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateTaskRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long insert(Task task) {
        sessionFactory.getCurrentSession().save(task);
        return task.getId();
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        Task task = (Task) sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(task);
    }

    @Override
    public boolean existsByName(String name) {
        String query = "select case when count(*)> 0 " +
                "then true else false end " +
                "from Task where name=" + name;
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public Optional<Task> findTaskByName(String name) {
        Task task = (Task) sessionFactory.getCurrentSession().createCriteria(Task.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        return Optional.ofNullable(task);
    }


    public List<Task> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Task.class)
                .list();
    }

    public void delete(Task task) {
        sessionFactory.getCurrentSession().delete(task);
    }
}
