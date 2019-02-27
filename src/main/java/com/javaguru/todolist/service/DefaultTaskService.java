package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.repository.TaskInMemoryRepository;
import com.javaguru.todolist.service.validation.TaskValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class DefaultTaskService implements TaskService {

    private final TaskInMemoryRepository repository;
    private final TaskValidationService validationService;

    @Autowired
    public DefaultTaskService(TaskInMemoryRepository repository,
                              TaskValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public Long createTask(Task task) {
        validationService.validate(task);
        Task createdTask = repository.insert(task);
        return createdTask.getId();
    }

    public Task findTaskById(Long id) {
        return repository.findTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found, id: " + id));
    }
}