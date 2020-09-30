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

    public static void printHelp(){
        System.out.println("Here are your list of commands:\n" +
                "1) list\n" +
                "   input: print\n" +
                "   Prints task list\n" +
                "2) todo\n" +
                "   input: todo <description>\n" +
                "   adds todo to task list\n" +
                "3) deadline\n" +
                "   input: deadline <description> /by <date and time>\n" +
                "          <date and time> must be in dd/MM/yy hh:mm (time in 24hr mode)\n" +
                "   Adds deadline to task list\n" +
                "4) event\n" +
                "   input: event <description> /at <date and time>\n" +
                "          <date and time> must be in dd/MM/yy hh:mm (time in 24hr mode)\n" +
                "   Adds event to task list\n" +
                "5) done\n" +
                "   input: done <task index>\n" +
                "   Marks task with task index on task list as done\n" +
                "6) delete\n" +
                "   input: delete <task index>\n" +
                "   Deletes task with task index on task list\n" +
                "7) find\n" +
                "   input: find <keyword>\n" +
                "   Returns tasks which consists of keyword\n" +
                "8) bye\n" +
                "   input: bye\n" +
                "   Ends program");
    }

}
