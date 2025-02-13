import java.util.Scanner;



public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to my TODO List");
        String[] options = {"1: Add", "2: Remove", "3: View"};
        
        ArrayTask taskList = new ArrayTask();
        try (Scanner scan = new Scanner(System.in)) {
            while(true){

            System.out.println("Pick an option ");
            //displays optinos
            for(int i = 0; i<options.length; i++){
                System.out.println(options[i].toString());
            }
            
            int userInput = -1;

            while(true){
                try {
                    userInput = Integer.parseInt(scan.nextLine());
                    if(userInput>=1 && userInput<=options.length){
                        break;
                    }
                    else{
                        System.out.println("Pick a valid option (1, 2, or 3): ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid number ");
                }
                
            }


            if(userInput == 1){
                while(true){
                String repeat = new String();
                Task task = new Task();

                System.out.println("Type the task you want done");
                String taskString = scan.nextLine();
                task.setTask(taskString);

                System.out.println("Type description ");
                String taskDescription = scan.nextLine();
                task.setDescription(taskDescription);

                taskList.insertTask(task);
                System.out.println("Task added!");

                System.out.println("Would you like to add another task? (Y/N)");
                while(true){
                repeat = scan.nextLine();

                if(repeat.equalsIgnoreCase("N")){
                    break;
                }
                else if(repeat.equalsIgnoreCase("Y")){
                    break;
                }
                else{
                    System.out.println("Please type Y or N");
                    
                }
            }

            if(repeat.equalsIgnoreCase("n"))
            break;
            
            } 
    }


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
                    
                }

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

                    if(taskList.getNumTask() == 0)
                    break;
                }else
                break;
                
                
               
            }
            }else if(userInput == 2){
                System.out.println("no tasks added\n");
            }

            if(userInput == 3 && taskList.getNumTask()>0){

               System.out.println(taskList.toString());
              

            }else if (userInput == 3){
            System.out.println("no task added\n");
            }
            
   }
        }
    }
    
}
