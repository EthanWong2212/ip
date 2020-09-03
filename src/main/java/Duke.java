import java.util.Scanner;


public class Duke {

    public static final String LOGO = "  _____ _   _                 \n" +
            " | ____| |_| |__   __ _ _ __  \n" +
            " |  _| | __| '_ \\ / _` | '_ \\ \n" +
            " | |___| |_| | | | (_| | | | |\n" +
            " |_____|\\__|_| |_|\\__,_|_| |_|\n" +
            "\n";
    public static final String INTRO = " Hi there, I'm Ethan!\n" +
            " Do you need anything?\n";
    public static final String BYE = " Bye. See you soon!\n" +
            "----------------------------BYE----------------------------\n";
    public static final String YOU = "----------------------------YOU----------------------------\n";
    public static final String ETHAN = "---------------------------ETHAN---------------------------\n";

    private static Task[] task_array= new Task[100];
    private static int taskCount=0;

    //Methods
    public static void printList(){
        for(int i=0; i<taskCount; i++) {
            System.out.println((i+1) + "." + task_array[i]);
        }
    }
    public static void addTask(Task t){
        task_array[taskCount]=t;
        taskCount++;
        System.out.println("Got it. I've added this task:");
        System.out.println("  "+ t);
        System.out.println("Now you have "+ taskCount+ (taskCount==1?" task":" tasks")+" in the list");
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
            String[] words=user_command.split(" ");
            if(user_command.equals("bye")) {
                break;
            } else if(user_command.equals("list")){
                printList();
            } else if(words[0].equals("done")){
                int done_index=Integer.parseInt(words[1])-1;
                task_array[done_index].isDone(true);
            } else if(words[0].equals("todo")){
                addTask(new Todo(user_command.substring(5)));
            } else if(words[0].equals("deadline")){
                int dividerPosition=user_command.indexOf("/");
                addTask(new Deadline(user_command.substring(9,dividerPosition-1),user_command.substring(dividerPosition+1)));
            } else if(words[0].equals("event")){
                int dividerPosition=user_command.indexOf("/");
                addTask(new Event(user_command.substring(6,dividerPosition-1),user_command.substring(dividerPosition+1)));
            } else{
                Task t= new Task(user_command);
                addTask(t);
            }
        }
        System.out.println(BYE);
    }
}
