package service;

import model.Task;

import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

public class TaskService {

    HashSet<Task> tasks = new HashSet<>();

    public Task create(String title, String description, Date deadline) {
        if (title == null || title.isEmpty()) return null;

        Task newTask = new Task(title, description, deadline);

        tasks.add(newTask);

        return newTask;
    }

    public Task getById(UUID id) {
        if (id == null) return null;

        for (Task task : tasks) {
            if (task.getUuid().equals(id)) return task;
        }

        return null;
    }

    public HashSet<Task> getAll() {
        return tasks;
    }

    public Task update(Task updatedTask) {
        if (updatedTask == null || updatedTask.getUuid() == null) return null;

        for (Task task : tasks) {
            if (task.getUuid().equals(updatedTask.getUuid())) {
                if (!updatedTask.getTitle().equals(task.getTitle())) {
                    task.setTitle(updatedTask.getTitle());
                }
                if (!updatedTask.getDescription().equals(task.getDescription())) {
                    task.setDescription(updatedTask.getDescription());
                }
                if (!updatedTask.getDeadline().equals(task.getDeadline())) {
                    task.setDeadline(updatedTask.getDeadline());
                }
                if (!updatedTask.getStatus().equals(task.getStatus())) {
                    task.setStatus(updatedTask.getStatus());
                }
            }
        }

        return updatedTask;
    }

    public Task delete(UUID id){
        if (id == null) return null;

        Task task = getById(id);
        if (task == null) return null;

        tasks.remove(task);

        return task;
    }
}
