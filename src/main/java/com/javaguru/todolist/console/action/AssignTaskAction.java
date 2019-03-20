package com.javaguru.todolist.console.action;

import com.javaguru.todolist.service.UserTaskService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
class AssignTaskAction implements Action {

    private static final String ACTION_NAME = "Assign task to user";

    private final UserTaskService userTaskService;

    AssignTaskAction(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id:");
        Long userId = scanner.nextLong();
        System.out.println("Enter task id: ");
        Long taskId = scanner.nextLong();

        userTaskService.assignTask(userId, taskId);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
