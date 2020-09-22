package Duke.Command;

import Duke.DukeException;
import Duke.Parser.Parser;
import Duke.Task.Task;
import Duke.Task.TaskList;
import Duke.Ui.Ui;

public class Command {
    public static void runCommand(String userCmd, TaskList taskList) throws DukeException {
        Task task;
        String[] cmd_split= userCmd.split(" ");
        String type=cmd_split[0].trim();
        switch (type){
        case"list":
            taskList.printList();
            break;
        case "todo":
            task=Parser.todo(userCmd);
            taskList.addTask(task);
            Ui.printTaskAdded(task,taskList);
            break;
        case "deadline":
            task=Parser.deadlineTask(userCmd);
            taskList.addTask(task);
            Ui.printTaskAdded(task,taskList);
            break;
        case "event":
            task=Parser.eventTask(userCmd);
            taskList.addTask(task);
            Ui.printTaskAdded(task,taskList);
            break;
        case "done":
            int doneIndex=Parser.doneIndex(userCmd);
            taskList.doneTask(doneIndex);
            break;
        case "delete":
            int deleteIndex=Parser.deleteIndex(userCmd);
            taskList.deleteTask(deleteIndex);
            break;
        default:
            throw new DukeException("invalid");
        }
    }
}
