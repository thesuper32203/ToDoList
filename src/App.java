import java.sql.*;
import java.util.Scanner;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception  {





        System.out.println("Welcome to my TODO List");
        String[] options = {"1: Add", "2: Remove", "3: View", "4: Load"};
        
        ArrayTask taskList = new ArrayTask();




        try (Scanner scan = new Scanner(System.in)) {
            //starts program
            while(true){

            System.out.println("Pick an option or type exit to end");
            //displays options
                for (String option : options) {
                    System.out.println(option);
                }
            
            int userInput = -1;
                String exit;

            while(true) try {
                exit = scan.nextLine();
                if (exit.equalsIgnoreCase("exit"))
                    break;
                userInput = Integer.parseInt(exit);

                if (userInput >= 1 && userInput <= options.length) {
                    break;
                } else {
                    System.out.println("Pick a valid option (1, 2, 3, or 4): ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid number or type exit ");
            }

            if(exit.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye");
                break;
            }
            //Add section
            if(userInput == 1){

                while(true){
                String repeat;
                Task task = new Task();

                System.out.println("Type the task you want done");
                String taskString = scan.nextLine();
                task.setTask(taskString);

                System.out.println("Type description ");
                String taskDescription = scan.nextLine();
                task.setDescription(taskDescription);

                System.out.println("What priority level (Low, Medium, High)");
                while(true) {

                    String taskPriority = scan.nextLine();

                    if(taskPriority.equalsIgnoreCase("Low") ||
                            taskPriority.equalsIgnoreCase("Medium") ||
                            taskPriority.equalsIgnoreCase("High")) {
                        task.setTaskPriority(taskPriority);
                        break;
                    }
               else{
                   System.out.println("Please enter valid setting ");
                    }
                }
                //if user chose high priority move it to beginning of the list
                if(task.getTaskPriority().equalsIgnoreCase("High")){
                    taskList.insertTaskAtBeginning(task);
                }
                else
                    taskList.insertTask(task);
                System.out.println("Task added!");

                System.out.println("Would you like to add another task? (Y/N)");
                while(true){
                repeat = scan.nextLine();

                if(repeat.equalsIgnoreCase("N")|| repeat.equalsIgnoreCase("Y")){
                    break;
                }
                else
                    System.out.println("Please type Y or N");

            }

            if(repeat.equalsIgnoreCase("n"))
                break;
                }
    }

        //Delete
            if(userInput == 2 && taskList.getNumTask()> 0){

                while(true){
                int userOpt;

                System.out.println(
                    "1: delete all\n" +
                    "2: delete at index\n" + 
                    "3: exit\n"
                );

                while(true){
                    try {
                        userOpt = Integer.parseInt(scan.nextLine());
                        if(userOpt == 1 || userOpt == 2 || userOpt == 3){
                            break;
                        }
                        else{
                            System.out.println("Pick a valid option (1, 2 or 3): ");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter valid number ");
                    }
                    
                }//ends while loop if user pick valid number to delete all, at index, or exit

                if(userOpt == 1){
                    taskList.deleteAllTask();
                    System.out.println("All task deleted");
                    break;
                }

                else if(userOpt == 2){

                    System.out.println("What index do you want to delete 0-" + (taskList.getNumTask()-1));
                    userOpt = Integer.parseInt(scan.nextLine());
                    boolean results = taskList.deleteTaskAtIndex(userOpt);
                    System.out.println(results? " deleted" : "not deleted");

                    if(taskList.getNumTask() == 0) {
                        break;
                    }//if there are no more task to delete exit out of delete option
                }else
                break;
                
                
               
            }// end of while loop for delete option
            }else if(userInput == 2) {
                System.out.println("no tasks are currently available to delete\n");
            }//end of if statement for delete option

        //View
            if(userInput == 3 && taskList.getNumTask()>0){
               System.out.println(taskList.toString());
            }else if( userInput == 33){
            System.out.println("no task added\n");
            }//end of view if statement

         //Load
           if(userInput == 4){
               try{
                    ArrayTask data = (ArrayTask) ResourseManagement.load("TaskList");
                    taskList = data.taskList;
               } catch (Exception e) {
                   System.out.println("Couldnt load save data: " + e.getMessage());
               }
           }
   }//end program
        }//end of scanner try block
        ArrayTask data = new ArrayTask();
        data.taskList = taskList;
        try{
            ResourseManagement.save(data, "TaskList");
            System.out.println("Saved data");
        }catch (Exception e){
            System.out.print("Couldnt save: " + e.getMessage());
        }

    }//end of main args
    
}
