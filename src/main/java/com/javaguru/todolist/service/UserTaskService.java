package com.javaguru.todolist.service;

import com.javaguru.todolist.domain.Task;
import com.javaguru.todolist.domain.User;
import com.javaguru.todolist.domain.UserTask;
import com.javaguru.todolist.repository.HibernateUserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTaskService {

    private final TaskService taskService;
    private final UserService userService;
    private final HibernateUserTaskRepository userTaskRepository;

    @Autowired
    UserTaskService(TaskService taskService,
                    UserService userService,
                    HibernateUserTaskRepository userTaskRepository) {
        this.taskService = taskService;
        this.userService = userService;
        this.userTaskRepository = userTaskRepository;
    }

    public Long assignTask(Long userId, Long taskId) {
        Task task = taskService.findTaskById(taskId);
        User user = userService.findUserById(userId);
        UserTask userTask = new UserTask();
        userTask.setTask(task);
        userTask.setUser(user);
        return userTaskRepository.save(userTask);
    }
}
