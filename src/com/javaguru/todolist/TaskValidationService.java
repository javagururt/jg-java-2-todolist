package com.javaguru.todolist;

import java.util.HashSet;
import java.util.Set;

class TaskValidationService {

    private Set<TaskValidationRule> validationRules = new HashSet<>();

    public TaskValidationService() {
        validationRules.add(new TaskNameValidationRule());
    }

    public void validate(Task task) {
        validationRules.forEach(s -> s.validate(task));
    }

}
