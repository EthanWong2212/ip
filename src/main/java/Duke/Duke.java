package Duke;

import Duke.FileHandler.FileHandler;
import Duke.Task.*;
import Duke.Ui.Ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
//    private static ArrayList<Task> task_list=new ArrayList<>();
    private static int taskCount=0;
    public static FileHandler file=new FileHandler("Duke","data/Duke.txt");
    public static TaskList tasklist= new TaskList();

    //Methods
//    public static void printList(){
//        for(Task task:task_list) {
//            System.out.println((task_list.indexOf(task)+1) + "." + task);
//        }
//    }

//    public static void addTask(Task t){
//        task_list.add(t);
//        taskCount++;
//        System.out.println("Got it. I've added this task:");
//        System.out.println("  "+ t);
//        System.out.println("Now you have "+ taskCount+ (taskCount==1?" task":" tasks")+" in the list");
//    }
//    public static void removeTask(Task t){
//        taskCount--;
//        task_list.remove(t);
//        System.out.println("Noted. I've removed this task:");
//        System.out.println("  "+ t);
//        System.out.println("Now you have "+ taskCount+ (taskCount==1?" task":" tasks")+" in the list");
//    }

    public static void runCommand(String user_command) throws DukeException{
        String[] words= user_command.split(" ");
        String description;
        String timing;
        int dividerPosition;
        if(user_command.equals("list")){
            tasklist.printList();
        } else if(words[0].equals("done")){
            try {
                int done_index=Integer.parseInt(words[1])-1;
                tasklist.doneTask(done_index);
            }catch(IndexOutOfBoundsException e){
                throw new DukeException("Done out of bounds");
            } catch(NumberFormatException e){
                throw new DukeException("Done empty");
            }

        } else if(words[0].equals("todo")){
            //Description missing handler
            try{
                description=user_command.substring(5);
                tasklist.addTask(new Todo(description));
            } catch(StringIndexOutOfBoundsException e){
                throw new DukeException("todo incomplete");
            }
        } else if(words[0].equals("deadline")){
            dividerPosition= user_command.indexOf("/");
            // Divider missing handler
            if(dividerPosition==-1){
                throw new DukeException("DL divider missing");
            }
            // Deadline incomplete handler
            try {
                description = user_command.substring(9, dividerPosition - 1);
                timing = user_command.substring(dividerPosition + 1);
                tasklist.addTask(new Deadline(description, timing));
            } catch(StringIndexOutOfBoundsException e){
                throw new DukeException("DL incomplete");
            }
        } else if(words[0].equals("event")){
            dividerPosition= user_command.indexOf("/");
            tasklist.addTask(new Event(user_command.substring(6,dividerPosition-1), user_command.substring(dividerPosition+1)));
        } else if(words[0].equals("delete")) {
            try{
                int remove_index=Integer.parseInt(words[1])-1;
                tasklist.deleteTask(remove_index);
            } catch(IndexOutOfBoundsException e){
                throw new DukeException("Delete out of bounds");
            }

        } else{
            throw new DukeException("invalid");
        }
//        try {
//            file.updateFile(task_list);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }



    //MAIN
    public static void main(String[] args) throws FileNotFoundException, DukeException {
        String user_command;
        Scanner in =new Scanner(System.in);
//        file.getInfo();
//        file.readFile(task_list);
//        taskCount= file.getTask_count();
        //Default start
        Ui.printStart();

        while(true){
            //Receive user commands
            Ui.printYou();
            user_command=in.nextLine();
            Ui.printETHAN();
            //Process and run commands
            if(user_command.equals("bye")) {
                break;
            }
            try {
                runCommand(user_command);
            } catch (DukeException e) {
                e.getError();
            }
        }
        Ui.printBye();
    }


}
