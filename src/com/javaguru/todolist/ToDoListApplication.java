package com.javaguru.todolist;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ToDoListApplication {

    private static Long taskIdSequence = 0L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Long, Task> repository = new HashMap<>();

        while (true) {
            try {
                System.out.println("1. Create task");
                System.out.println("2. Find task by id");
                System.out.println("3. Exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        createTask(repository);
                        break;
                    case 2:
                        findTask(repository);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private static void createTask(Map<Long, Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task name: ");
        String name = scanner.nextLine();
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();

        Task task = new Task();
        task.setName(name);
        task.setDescription(description);

        if (task.getName() == null) {
            throw new IllegalArgumentException("Task name must be not null.");
        }

        task.setId(taskIdSequence);
        tasks.put(task.getId(), task);
        taskIdSequence++;

        System.out.println("Task created, id:  " + task.getId());
    }

    private static void findTask(Map<Long, Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task id: ");
        Long id = scanner.nextLong();
        Task task = tasks.get(id);
        System.out.println(task);
    }
}
