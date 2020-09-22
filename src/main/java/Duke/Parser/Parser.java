package Duke.Parser;

import Duke.DukeException;
import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;

public class Parser {
    private static final String DEADLINE_DIV="/by";
    private static final String EVENT_DIV="/at";

    public static Task deadlineTask(String userCmd) throws DukeException {
        String[] cmdSplit= userCmd.split(DEADLINE_DIV);
        String desc=cmdSplit[0].substring(9).trim();
        String time=cmdSplit[1].trim();
        return new Deadline(desc,time);
    }
    public static Task eventTask(String userCmd){
        String[] cmdSplit= userCmd.split(EVENT_DIV);
        String desc=cmdSplit[0].substring(6).trim();
        String time=cmdSplit[1].trim();
        return new Event(desc,time);
    }
    public static Task todo(String userCmd) throws DukeException {
        String desc= userCmd.substring(5).trim();
        return new Todo(desc);
    }
    public static int doneIndex(String userCmd){
        String indexStr= userCmd.substring(5).trim();
        int index=Integer.parseInt(indexStr)-1;
        return index;
    }
    public static int deleteIndex(String userCmd){
        String indexStr= userCmd.substring(7).trim();
        int index=Integer.parseInt(indexStr)-1;
        return index;
    }

}