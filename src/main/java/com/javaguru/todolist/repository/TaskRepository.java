package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.Task;

import java.util.Optional;

public interface TaskRepository {

    Long insert(Task task);

    Optional<Task> findTaskById(Long id);

    boolean existsByName(String name);

    Optional<Task> findTaskByName(String name);
}
