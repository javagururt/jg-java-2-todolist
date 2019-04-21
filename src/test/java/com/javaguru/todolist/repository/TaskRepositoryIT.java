package com.javaguru.todolist.repository;

import com.javaguru.todolist.config.AppConfig;
import com.javaguru.todolist.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryIT {

    @Autowired
    private TaskRepository victim;

    @Test
    public void shouldSaveTask() {
        Task task = new Task();
        task.setName("TEST_NAME");
        task.setDescription("TEST_DESCRIPTION");

        Task result = victim.save(task);

        assertThat(result).isEqualTo(expectedTask(task.getId()));
    }

    @Test
    public void shouldFindTaskByName() {
        Task task = new Task();
        task.setName("TEST_NAME");
        task.setDescription("TEST_DESCRIPTION");

        Task savedTask = victim.save(task);

        Optional<Task> result = victim.findTaskByName("TEST_NAME");

        assertThat(result).hasValue(expectedTask(savedTask.getId()));
    }

    @Test
    public void shouldFindTaskById() {
        Task task = new Task();
        task.setName("TEST_NAME");
        task.setDescription("TEST_DESCRIPTION");

        Task savedTask = victim.save(task);
        Long id = savedTask.getId();

        Optional<Task> result = victim.findTaskById(id);
        assertThat(result).hasValue(expectedTask(id));
    }

    @Test
    public void shouldExistsByName() {
        Task task = new Task();
        task.setName("TEST_NAME");
        task.setDescription("TEST_DESCRIPTION");

        victim.save(task);

        boolean result = victim.existsByName("TEST_NAME");
        assertThat(result).isTrue();
    }

    public Task expectedTask(Long id) {
        Task task = new Task();
        task.setName("TEST_NAME");
        task.setDescription("TEST_DESCRIPTION");
        task.setId(id);
        return task;
    }
}