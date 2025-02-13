public class Task {
    

    String task;
    String description;


    public Task(){

        task = new String();
        description = new String();

    }

    public Task(String task, String description){

        this.task = task;
        this.description = description;

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

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("Task: " + task);
        sb.append("\nDesc: " + description);
        sb.append("\n");
        return sb.toString();

    }

    
    
}
