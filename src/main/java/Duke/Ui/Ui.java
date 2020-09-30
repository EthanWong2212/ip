package Duke.Ui;

import Duke.Task.Task;
import Duke.Task.TaskList;

public class Ui {
    private static final String LOGO = "  _____ _   _\n" +
            " | ____| |_| |__   __ _ _ __\n" +
            " |  _| | __| '_ \\ / _` | '_ \\\n" +
            " | |___| |_| | | | (_| | | | |\n" +
            " |_____|\\__|_| |_|\\__,_|_| |_|\n" +
            "\n";
    private static final String INTRO = " Hi there, I'm Ethan!\n" +
            " Do you need anything?\n";
    private static final String BYE = " Bye. See you soon!\n" +
            "----------------------------BYE----------------------------";
    private static final String YOU = "----------------------------YOU----------------------------\n";
    private static final String ETHAN = "---------------------------ETHAN---------------------------\n";

    public static void printBye(){
        System.out.println(BYE);
    }
    public static void printYou(){
        System.out.println(YOU);
    }
    public static void printETHAN(){
        System.out.println(ETHAN);
    }
    public static void printStart() {
        System.out.println("Hello from\n" + LOGO + ETHAN + INTRO);
    }
    public static void printTaskAdded(Task task, TaskList taskList){
        System.out.println("Got it. I've added this task:");
        System.out.println("  "+ task);
        System.out.println("Now you have "+ taskList.getSize()+ (taskList.getSize()==1?" task":" tasks")+" in the list");
    }
    public static void printTaskDeleted(Task task, int size){
        System.out.println("Noted. I've removed this task:");
        System.out.println("  "+ task);
        System.out.println("Now you have "+ size+ (size<1?" task":" tasks")+" in the list");
    }
    public static void printTaskDone(Task task, int notDone){
        System.out.println("Great Job! The task has been marked as done:");
        System.out.println(task);
        System.out.println("You have " + notDone + " tasks not done");
    }

}
