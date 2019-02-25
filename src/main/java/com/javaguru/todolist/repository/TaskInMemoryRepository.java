package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.Task;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class TaskInMemoryRepository {

    private Long taskIdSequence = 0L;
    private Map<Long, Task> tasks = new HashMap<>();

    public Task insert(Task task) {
        task.setId(taskIdSequence);
        tasks.put(taskIdSequence, task);
        taskIdSequence++;
        return task;
    }

    public Optional<Task> findTaskById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public boolean existsByName(String name) {
        return tasks.values().stream()
                .anyMatch(task -> task.getName().equalsIgnoreCase(name));
    }

    public Optional<Task> findTaskByName(String name) {
        return tasks.values().stream()
                .filter(task -> task.getName().equalsIgnoreCase(name))
                .findFirst();
    }

}
