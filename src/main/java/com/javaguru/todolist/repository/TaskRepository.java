package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findTaskById(Long id);

    boolean existsByName(String name);

    Optional<Task> findTaskByName(String name);

}