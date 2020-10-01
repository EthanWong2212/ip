package Duke;

import Duke.Command.Command;
import Duke.Storage.FileHandler;

import Duke.Task.TaskList;
import Duke.Ui.Ui;

import java.io.IOException;
import java.util.Scanner;



public class Duke {
    public static FileHandler file=new FileHandler("Duke","data/Duke.txt");
    public static TaskList taskList= new TaskList();

    public static void main(String[] args) throws IOException, DukeException {
        String userCmd;
        Scanner in =new Scanner(System.in);
        file.getInfo();
        file.readFile(taskList);

        Ui.printStart();

        while(true){
            Ui.printYou();
            userCmd=in.nextLine();
            Ui.printETHAN();
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











