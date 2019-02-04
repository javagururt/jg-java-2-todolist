package com.javaguru.todolist;

public class TaskNameValidationRule implements TaskValidationRule {

    @Override
    public void validate(Task task) {
        checkNotNull(task);
        if (task.getName() == null) {
            throw new TaskValidationException("Task name must be not null.");
        }
    }
}
