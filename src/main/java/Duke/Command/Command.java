package Duke.Command;

import Duke.DukeException;
import Duke.Parser.Parser;
import Duke.Task.Task;
import Duke.Task.TaskList;
import Duke.Ui.Ui;

public class Command {

    public static final String CMD_LIST = "list";
    public static final String CMD_TODO = "todo";
    public static final String CMD_DEADLINE = "deadline";
    public static final String CMD_EVENT = "event";
    public static final String CMD_DONE = "done";
    public static final String CMD_DELETE = "delete";
    public static final String CMD_FIND ="find";
    public static final String CMD_HELP="help";

    /**
     * Modifies taskList according to user input.
     * If user input command is invalid, exception is thrown.
     *
     * @param userCmd   Full input by user.
     * @param taskList  taskList which requires relevant modifications by user input command.
     * @throws DukeException    If user input command invalid.
     */


    public static void runCommand(String userCmd, TaskList taskList) throws DukeException {
        Task task;
        String[] cmd_split= userCmd.split(" ");
        String type=cmd_split[0].trim().toLowerCase();
        switch (type){
        case CMD_LIST:
            taskList.printList();
            break;
        case CMD_TODO:
            task=Parser.getTodoTask(userCmd);
            taskList.addTask(task);
            Ui.printTaskAdded(task,taskList);
            break;
        case CMD_DEADLINE:
        case CMD_EVENT:
            task=Parser.getDeadlineEventTask(userCmd, type);
            taskList.addTask(task);
            Ui.printTaskAdded(task,taskList);
            break;
        case CMD_DONE:
            int doneIndex=Parser.getDoneDeleteIndex(userCmd, type, taskList.getSize());
            taskList.doneTask(doneIndex);
            break;
        case CMD_DELETE:
            int delIndex=Parser.getDoneDeleteIndex(userCmd, type, taskList.getSize());
            taskList.deleteTask(delIndex);
            break;
        case CMD_FIND:
            String key=Parser.getFindKeyword(userCmd);
            taskList.findTask(key);
            break;
        case CMD_HELP:
            Ui.printHelp();
            break;
        default:
            throw new DukeException("invalid");
        }
    }
}
