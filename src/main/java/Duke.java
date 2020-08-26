import java.util.Arrays;
import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        //Default start
        String logo=    "  _____ _   _                 \n" +
                        " | ____| |_| |__   __ _ _ __  \n" +
                        " |  _| | __| '_ \\ / _` | '_ \\ \n" +
                        " | |___| |_| | | | (_| | | | |\n" +
                        " |_____|\\__|_| |_|\\__,_|_| |_|\n" +
                        "\n";
        String intro =  " Hi there, I'm Ethan!\n" +
                        " Do you need anything?\n";
        String bye=     " Bye. See you soon!\n" +
                        "----------------------------BYE----------------------------\n";
        String you=     "----------------------------YOU----------------------------\n";
        String ethan=   "---------------------------ETHAN---------------------------\n";
        System.out.println("Hello from\n" + logo+ethan+intro);




        Scanner in =new Scanner(System.in);
        String user_command;
        Task[] task_array= new Task[100];
        int task_array_i=0;



        while(true){
            System.out.println(you);
            user_command=in.nextLine();
            System.out.println(ethan);

            String[] words=user_command.split(" ");
            if(user_command.equals("bye")) {
                break;
            }
            if(user_command.equals("list")){
                for(Task task : Arrays.copyOf(task_array,task_array_i)){
                    System.out.println(task.tasknumber+"."+task.getStatusIcon()+" "+task.description);
                }
            } else if(words[0].equals("done")){
                int done_index=Integer.parseInt(words[1])-1;
                task_array[done_index].isDone=true;
                System.out.println("Great Job! The task has been marked as done:");
                System.out.println(task_array[done_index].getStatusIcon()+" "+task_array[done_index].description);
            }else{
                Task t= new Task(user_command,task_array_i+1);
                task_array[task_array_i]=t;
                task_array_i++;
                System.out.println("added: "+t.description);
            }


        }

        System.out.println(bye);
    }



}
