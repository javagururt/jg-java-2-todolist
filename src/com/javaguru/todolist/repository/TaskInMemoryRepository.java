package com.javaguru.todolist.repository;

import com.javaguru.todolist.domain.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskInMemoryRepository {

    private Long TASK_ID_SEQUENCE = 0L;
    private Map<Long, Task> tasks = new HashMap<>();

    public Task insert(Task task) {
        task.setId(TASK_ID_SEQUENCE);
        tasks.put(TASK_ID_SEQUENCE, task);
        TASK_ID_SEQUENCE++;
        return task;
    }

    public Task findTaskById(Long id) {
        return tasks.get(id);
    }
}
