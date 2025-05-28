package service;

import enumeration.Status;
import model.Task;

import java.util.*;

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

    public HashSet<Task> getAllByStatus(Status status) {
        HashSet<Task> result = new HashSet<>();
        if (status == null) return result;

        for (Task task : tasks) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }

        return result;
    }

    public HashSet<Task> getAllExpired() {
        HashSet<Task> result = new HashSet<>();
        Date now = new Date();

        for (Task task : tasks) {
            if (now.after(task.getDeadline())) {
                result.add(task);
            }
        }

        return result;
    }

    public Set<Task> sortByDeadline(boolean ascending) {
        List<Task> result = new ArrayList<>(tasks);

        Comparator<Date> comparable = ascending ? Comparator.naturalOrder() : Comparator.reverseOrder();

        result.sort(Comparator.comparing(Task::getDeadline, Comparator.nullsLast(comparable)));

        return new LinkedHashSet<>(result);
    }

    public Task update(Task updatedTask) {
        if (updatedTask == null || updatedTask.getUuid() == null) return null;

        for (Task task : tasks) {
            if (task.getUuid().equals(updatedTask.getUuid())) {

                updatedTask.setTitle(getUpdate(task.getTitle(), updatedTask.getTitle()));
                updatedTask.setDescription(getUpdate(task.getDescription(), updatedTask.getDescription()));
                updatedTask.setDeadline(getUpdate(task.getDeadline(), updatedTask.getDeadline()));
                updatedTask.setStatus(getUpdate(task.getStatus(), updatedTask.getStatus()));

                return updatedTask;
            }
        }

        return null;
    }

    private <T> T getUpdate(T oldValue, T newValue) {
        if (oldValue == null && newValue == null) {
            return null;
        } else if (oldValue == null) {
            return newValue;
        } else if (newValue == null) {
            return null;
        } else if (!oldValue.equals(newValue)) {
            return newValue;
        }
        else return oldValue;
    }

    public Task delete(UUID id){
        if (id == null) return null;

        Task task = getById(id);
        if (task == null) return null;

        tasks.remove(task);

        return task;
    }
}
