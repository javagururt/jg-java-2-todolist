package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.Task;

public interface TaskService {

    Long createTask(Task task);

    Task findTaskById(Long id);
}
