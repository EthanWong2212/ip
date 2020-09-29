package Duke.Command;

import Duke.DukeException;
import Duke.Parser.Parser;
import Duke.Task.Task;
import Duke.Task.TaskList;
import Duke.Ui.Ui;

public class Command {

    public static final String COMMAND_LIST = "list";
    public static final String COMMAND_TODO = "todo";
    public static final String COMMAND_DEADLINE = "deadline";
    public static final String COMMAND_EVENT = "event";
    public static final String COMMAND_DONE = "done";
    public static final String COMMAND_DELETE = "delete";

    public static void runCommand(String userCmd, TaskList taskList) throws DukeException {
        Task task;
        String[] cmd_split= userCmd.split(" ");
        String type=cmd_split[0].trim().toLowerCase();
        switch (type){
        case COMMAND_LIST:
            taskList.printList();
            break;
        case COMMAND_TODO:
            task=Parser.todo(userCmd);
            taskList.addTask(task);
            Ui.printTaskAdded(task,taskList);
            break;
        case COMMAND_DEADLINE:
        case COMMAND_EVENT:
            task=Parser.deadlineeventTask(userCmd, type);
            taskList.addTask(task);
            Ui.printTaskAdded(task,taskList);
            break;
        case COMMAND_DONE:
            int doneIndex=Parser.donedeleteIndex(userCmd, type, taskList.getSize());
            taskList.doneTask(doneIndex);
            break;
        case COMMAND_DELETE:
            int delIndex=Parser.donedeleteIndex(userCmd, type, taskList.getSize());
            taskList.deleteTask(delIndex);
            break;
        default:
            throw new DukeException("invalid");
        }
    }
}
