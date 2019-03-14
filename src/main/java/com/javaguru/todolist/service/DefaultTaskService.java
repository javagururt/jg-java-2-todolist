package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.repository.TaskRepository;
import com.javaguru.todolist.service.validation.TaskValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class DefaultTaskService implements TaskService {

    private final TaskRepository repository;
    private final TaskValidationService validationService;

    @Autowired
    public DefaultTaskService(TaskRepository repository,
                              TaskValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    @Transactional
    public Long createTask(Task task) {
        validationService.validate(task);
        return repository.insert(task);
    }

    public Task findTaskById(Long id) {
        return repository.findTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found, id: " + id));
    }
}