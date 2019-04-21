package com.javaguru.todolist.controller;

import com.javaguru.todolist.dto.TaskDto;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.endsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class TaskControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateTask() throws Exception {
        mockMvc.perform(post("/tasks/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(taskJson()))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", endsWith("/tasks/" + taskDto().getId())));
    }

    @Test
    public void shouldFindTaskById() throws Exception {
        mockMvc.perform(post("/tasks/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(taskJson()))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", endsWith("/tasks/" + taskDto().getId())));

        mockMvc.perform(get("/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    private TaskDto taskDto() {
        TaskDto taskDto = new TaskDto();
        taskDto.setName("TEST_NAME");
        taskDto.setDescription("TEST_DESCRIPTION");
        taskDto.setId(1L);
        return taskDto;
    }


    private String taskJson() throws JSONException {
        return new JSONObject()
                .put("name", "TEST_NAME")
                .put("description", "TEST_DESCRIPTION")
                .toString();
    }
}