package exceptions.task;

public class TaskAlreadyExistException extends Exception {
    public TaskAlreadyExistException(String taskToString) {
        super("Exception: " + taskToString + " already exists");
    }
}
