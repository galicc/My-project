package model;

import enumeration.Status;

import java.util.Date;
import java.util.UUID;

public class Task {

    private UUID uuid;
    private String title;
    private String description;
    private Date deadline;
    private Status status;

    public Task() {
        this.uuid = UUID.randomUUID();
        this.status = Status.TODO;
    }

    public Task(String title, String description, Date deadline) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = Status.TODO;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [uuid=" + uuid +
                ", title=" + title +
                ", description=" + description +
                ", deadline=" + deadline +
                ", status=" + status + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (this.getClass() != obj.getClass()) {
            return false;
        }
        else {
            return this.uuid.equals(((Task) obj).getUuid());
        }
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
