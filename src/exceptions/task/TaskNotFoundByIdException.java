package exceptions.task;

public class TaskNotFoundByIdException extends Exception {
    public TaskNotFoundByIdException(String id) {
        super("Exception: Task with id: " + id + " not found");
    }
}
