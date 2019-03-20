package com.javaguru.todolist.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="user_tasks")
public class UserTask {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTask userTask = (UserTask) o;
        return Objects.equals(id, userTask.id) &&
                Objects.equals(task, userTask.task) &&
                Objects.equals(user, userTask.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task, user);
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "id=" + id +
                ", task=" + task +
                ", user=" + user +
                '}';
    }
}
