package Duke.Parser;

import Duke.Duke;
import Duke.DukeException;
import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;

public class Parser {
    private static final String DEADLINE_DIV="/by";
    private static final String EVENT_DIV="/at";
    private static String desc;
    private static String time;
    private static String indexStr;
    private static int index;
    private static String[] cmdSplit;

    public static Task deadlineTask(String userCmd) throws DukeException {
        cmdSplit= userCmd.split(DEADLINE_DIV);
        if((!userCmd.contains(DEADLINE_DIV)) && cmdSplit.length==1){
            throw new DukeException("Event divider missing");
        }
        try {
            desc = cmdSplit[0].substring(9).trim();
        } catch (StringIndexOutOfBoundsException e){
            throw new DukeException("Desc missing");
        }
        try {
            time = cmdSplit[1].trim();
        } catch (ArrayIndexOutOfBoundsException e){
            throw new DukeException("Time missing");
        }
        if(desc.isBlank()){
            throw new DukeException("Desc missing");
        } else if(time.isBlank()){
            throw new DukeException("Time missing");
        }
        return new Deadline(desc,time);
    }
    public static Task eventTask(String userCmd) throws DukeException {
        String[] cmdSplit = userCmd.split(EVENT_DIV);
        if((!userCmd.contains(EVENT_DIV)) && cmdSplit.length==1){
            throw new DukeException("Event divider missing");
        }
        try {
            desc = cmdSplit[0].substring(6).trim();
        } catch (StringIndexOutOfBoundsException e){
            throw new DukeException("Desc missing");
        }
        try {
            time = cmdSplit[1].trim();
        } catch (ArrayIndexOutOfBoundsException e){
            throw new DukeException("Time missing");
        }
        if(desc.isBlank()){
            throw new DukeException("Desc missing");
        } else if(time.isBlank()){
            throw new DukeException("Time missing");
        }
        return new Event(desc, time);
    }
    public static Task todo(String userCmd) throws DukeException {
        try{
            String desc= userCmd.substring(5).trim();
            return new Todo(desc);
        } catch(StringIndexOutOfBoundsException e){
            throw new DukeException("Desc missing");
        }

    }
    public static int doneIndex(String userCmd){
        indexStr= userCmd.substring(5).trim();
        index=Integer.parseInt(indexStr)-1;
        return index;
    }
    public static int deleteIndex(String userCmd){
        indexStr= userCmd.substring(7).trim();
        index=Integer.parseInt(indexStr)-1;
        return index;
    }

}