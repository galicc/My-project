import model.Task;
import service.TaskService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        TaskService taskService = new TaskService();

        Task task1 = taskService.create("Title 1", null, new Date());
        task1.setDescription("Description 1");
        taskService.update(task1);
    }
}