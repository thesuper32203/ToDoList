import java.io.Serializable;

public class ArrayTask implements Serializable {

    private static final long serialversionUID = 1L;
    private Task[] tasks;
    private int numTasks;


    public String name;
    public ArrayTask taskList;

    /**
     * Default constructor 
     * Creates storage for at most 3 tasks and sets the nuber of
     * tasks as 0
     */
    public ArrayTask(){
       
        tasks = new Task[3];
        numTasks = 0;

    }

    /**
     * getNumTask method 
     * returns  the number of task currenntly in the array
     * @return numTasks
     */
    public int getNumTask(){

        return numTasks;

    }

    public void insertTask(Task taskInfo){

        if(numTasks == tasks.length) {
            this.increaseSize();
        }
        if(numTasks < tasks.length){
            tasks[numTasks] = taskInfo;
            numTasks++;
        }

    }

    public void insertTaskAtBeginning(Task task){


        if(numTasks == tasks.length){
            this.increaseSize();
        }



        for(int i = numTasks; i>0; i--){
            tasks[i] = tasks[i-1];
        }

        tasks[0] = task;
        numTasks++;


    }

    public boolean deleteTaskAtIndex(int taskNum){
         // Check if the index is valid
        if(taskNum>numTasks-1|| taskNum<0)
        return false;

          // Shift all tasks after the deleted task to the left
        for(int index = taskNum; index<numTasks-1; index++){
            tasks[index] = tasks[index+1];
        }

        tasks[numTasks-1] = null;
       
        numTasks--;

        return true;
    }

        public void deleteAllTask(){

            while(numTasks!=0){
                tasks[numTasks-1] = null;
                numTasks--;
            }

        }


        public void increaseSize(){

            Task[] newTasks = new Task[tasks.length*2];
            for(int i = 0; i< numTasks; i++){
                newTasks[i] = tasks[i];
            }
            tasks = newTasks;
        }

        public void sortByDate(){

        }

        public void sortByPriority(){

        }


        public void editTask(int index, String task, String description, String taskPriority){


            Task tempTask = new Task(task, description, taskPriority);
            tasks[index] = tempTask;


        }

        public String toString(){

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<numTasks; i++){
                sb.append("Task " + (i+1) + " \n" + tasks[i].toString());
                if(i<numTasks-1){
                    sb.append("\n");
                }
            }
            return sb.toString();
        }

        







}