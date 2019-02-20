package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskInMemoryRepository {

    private Long taskIdSequence = 0L;
    private Map<Long, Task> tasks = new HashMap<>();

    public Task insert(Task task) {
        task.setId(taskIdSequence);
        tasks.put(taskIdSequence, task);
        taskIdSequence++;
        return task;
    }

    public Task findTaskById(Long id) {
        return tasks.get(id);
    }

    public boolean existsByName(String name) {
        return tasks.values()
                .stream()
                .anyMatch(task -> task.getName().equalsIgnoreCase(name));
    }
}
