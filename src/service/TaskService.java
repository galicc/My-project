package service;

import model.Task;

import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

public class TaskService {

    HashSet<Task> tasks = new HashSet<>();

    public Task create(String title, String description, Date deadline){
        if (title == null ||
            description == null ||
            deadline == null
        ) return null;

        Task newTask = new Task(title, description, deadline);

        tasks.add(newTask);

        return newTask;
    }

    public Task getById(UUID id){
        if (id == null) return null;

        for(Task task : tasks){
            if (task.getUuid().equals(id)) return task;
        }

        return null;
    }

    public HashSet<Task> getAll(){
        return tasks;
    }

    public Task update(Task updatedTask){
        if (updatedTask == null) return null;
        if (updatedTask.getUuid() == null ||
            updatedTask.getTitle() == null ||
            updatedTask.getDescription() == null  ||
            updatedTask.getDeadline() == null  ||
            updatedTask.getStatus() == null
        ) return null;

        Task task = getById(updatedTask.getUuid());
        if (task == null) return null;

        tasks.remove(task);
        tasks.add(updatedTask);

        return updatedTask;
    }

    public boolean delete(UUID id){
        Task task = getById(id);
        if (task == null) return false;

        tasks.remove(task);

        return true;
    }
}
