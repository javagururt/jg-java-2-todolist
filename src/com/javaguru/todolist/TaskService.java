package com.javaguru.todolist;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskService {

    private Map<Long, Task> database = new HashMap<>();
    private Long TASK_ID_SEQUENCE = 0L;

    public void createTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();

        Task task = new Task();
        task.setName(name);
        task.setDescription(description);

        task.setId(TASK_ID_SEQUENCE);

        database.put(TASK_ID_SEQUENCE, task);

        System.out.println("Task created, id:  " + task.getId());
        TASK_ID_SEQUENCE++;
    }

    public void findTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task id: ");
        Long id = scanner.nextLong();
        Task task = database.get(id);
        System.out.println(task);
    }
}
