package com.javaguru.todolist;

public interface TaskValidationRule {

    void validate(Task task);

    default void checkNotNull(Task task) {
        if (task == null) {
            throw new TaskValidationException("Task must be not null");
        }
    }
}
