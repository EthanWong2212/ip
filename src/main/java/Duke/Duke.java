package Duke;

import Duke.Command.Command;
import Duke.FileHandler.FileHandler;
import Duke.Task.*;
import Duke.Ui.Ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Duke {
    public static FileHandler file=new FileHandler("Duke","data/Duke.txt");
    public static TaskList taskList= new TaskList();

    //MAIN
    public static void main(String[] args) throws IOException, DukeException {
        String userCmd;
        Scanner in =new Scanner(System.in);
        file.getInfo();
        file.readFile(taskList);
        //Default start
        Ui.printStart();

        while(true){
            //Receive user commands
            Ui.printYou();
            userCmd=in.nextLine();
            Ui.printETHAN();
            //Process and run commands
            if(userCmd.toLowerCase().equals("bye")) {
                break;
            }
            try {
                Command.runCommand(userCmd, taskList);
            } catch (DukeException e) {
                e.getError();
            }
            file.updateFile(taskList);
        }
        Ui.printBye();
    }

}











