package com.javaguru.todolist;

public class TaskService {

    private TaskInMemoryRepository repository = new TaskInMemoryRepository();
    private TaskValidationService validationService = new TaskValidationService();

    public Long createTask(Task task) {
        validationService.validate(task);
        Task createdTask = repository.insert(task);
        return createdTask.getId();
    }

    public Task findTaskById(Long id) {
        return repository.findTaskById(id);
    }
}