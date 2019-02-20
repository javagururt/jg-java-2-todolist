package com.javaguru.todolist.service.validation;

import com.javaguru.todolist.domain.Task;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TaskNameValidationRuleTest {

    private TaskNameValidationRule victim = new TaskNameValidationRule();

    private Task input;

    @Test
    public void shouldThrowTaskValidationException() {
        input = task(null);

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(TaskValidationException.class)
                .hasMessage("Task name must be not null.");
    }

    @Test
    public void shouldValidateSuccess() {
        input = task("valid name");

        victim.validate(input);
    }

    private Task task(String name) {
        Task task = new Task();
        task.setName(name);
        return task;
    }

}