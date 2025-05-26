import model.Task;

import java.util.Date;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Date date = new Date(); // same date

        System.out.println();

        Task emptyTask = new Task();
        emptyTask.setUuid(UUID.fromString("f5f753a5-2fe7-4661-9d15-b10cd7055c13"));
        emptyTask.setTitle("Title");
        emptyTask.setDescription("Description");
        emptyTask.setDeadline(date);
        System.out.println(emptyTask);
        System.out.println(emptyTask.hashCode());

        Task task = new Task("Title", "Description", date);
        //task.setUuid(UUID.fromString("f5f753a5-2fe7-4661-9d15-b10cd7055c13"));
        System.out.println(task);
        System.out.println(task.hashCode());

        System.out.println(emptyTask.equals(task));

    }
}