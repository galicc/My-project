package exceptions.task;

public class TaskNotExistException extends Exception {
    public TaskNotExistException(String id) {
        super("Exception: Task with id: " + id + " does not exist");
    }
}
