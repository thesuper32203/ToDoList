import java.io.Serializable;
import java.time.LocalDateTime;

 class Task implements Serializable {
    

    String task;
    String description;
    LocalDateTime dateTime;
    String taskPriority;

    public Task(){

        task = new String();
        description = new String();
        dateTime = LocalDateTime.now();
        taskPriority = "Low";

    }

    public Task(String task, String description, String taskPriority){

        this.task = task;
        this.description = description;
        dateTime = LocalDateTime.now();
        this.taskPriority = taskPriority;

    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

     public String getTaskPriority() {
         return taskPriority;
     }

     public void setTaskPriority(String taskPriority) {
         this.taskPriority = taskPriority;
     }



     public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("Time Created - " + dateTime );
        sb.append("\nPriority: " + taskPriority);
        sb.append("\nTask: " + task);
        sb.append("\nDesc: " + description);
        sb.append("\n");
        return sb.toString();

    }

    
    
}
