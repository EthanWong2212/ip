import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String user_command;
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
        while(true){
            System.out.println(you);
            user_command=in.nextLine();
            System.out.println(ethan);
            if(user_command.equals("bye")) {
                break;
            }
            Task t= new Task(user_command);

        }

        System.out.println(bye);
    }



}
