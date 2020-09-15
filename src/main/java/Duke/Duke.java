package Duke;

import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;

import java.util.ArrayList;
import java.util.Scanner;


public class Duke {

    public static final String LOGO = "  _____ _   _\n" +
            " | ____| |_| |__   __ _ _ __\n" +
            " |  _| | __| '_ \\ / _` | '_ \\\n" +
            " | |___| |_| | | | (_| | | | |\n" +
            " |_____|\\__|_| |_|\\__,_|_| |_|\n" +
            "\n";
    public static final String INTRO = " Hi there, I'm Ethan!\n" +
            " Do you need anything?\n";
    public static final String BYE = " Bye. See you soon!\n" +
            "----------------------------BYE----------------------------";
    public static final String YOU = "----------------------------YOU----------------------------\n";
    public static final String ETHAN = "---------------------------ETHAN---------------------------\n";

    private static ArrayList<Task> task_list=new ArrayList<>();
    private static int taskCount=0;

    //Methods
    public static void printList(){
        for(Task task:task_list) {
            System.out.println((task_list.indexOf(task)+1) + "." + task);
        }
    }

    public static void addTask(Task t){
        task_list.add(t);
        taskCount++;
        System.out.println("Got it. I've added this task:");
        System.out.println("  "+ t);
        System.out.println("Now you have "+ taskCount+ (taskCount==1?" task":" tasks")+" in the list");
    }

    public static void runCommand(String user_command) throws DukeException{
        String[] words= user_command.split(" ");
        String description;
        String timing;
        int dividerPosition;
        if(user_command.equals("list")){
            printList();
        } else if(words[0].equals("done")){
            try {
                int done_index=Integer.parseInt(words[1])-1;
                task_list.get(done_index).isDone(true);
            }catch(IndexOutOfBoundsException e){
                throw new DukeException("Done out of bounds");
            } catch(NumberFormatException e){
                throw new DukeException("Done empty");
            }

        } else if(words[0].equals("todo")){
            //Description missing handler
            try{
                description=user_command.substring(5);
                addTask(new Todo(description));
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
                addTask(new Deadline(description, timing));
            } catch(StringIndexOutOfBoundsException e){
                throw new DukeException("DL incomplete");
            }
        } else if(words[0].equals("event")){
            dividerPosition= user_command.indexOf("/");
            addTask(new Event(user_command.substring(6,dividerPosition-1), user_command.substring(dividerPosition+1)));
        } else{
            throw new DukeException("invalid");
        }

    }



    //MAIN
    public static void main(String[] args) {
        String user_command;
        Scanner in =new Scanner(System.in);

        //Default start
        System.out.println("Hello from\n" + LOGO + ETHAN + INTRO);

        while(true){
            //Receive user commands
            System.out.println(YOU);
            user_command=in.nextLine();
            System.out.println(ETHAN);
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
        System.out.println(BYE);
    }


}
