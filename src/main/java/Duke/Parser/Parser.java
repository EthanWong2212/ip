package Duke.Parser;

import Duke.DukeException;
import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;

public class Parser {
    private static final String DEADLINE_DIV="/by";
    private static final String EVENT_DIV="/at";
    public static final int DEADLINE_CMD_LENGTH = 8;
    public static final int EVENT_CMD_LENGTH=5;
    public static final int TODO_CMD_LENGTH=4;
    public static final int DONE_CMD_LENGTH=4;
    public static final int DELETE_CMD_LENGTH=6;
    public static final String DESC_MISSING = "Desc missing";
    public static final String TIME_MISSING = "Time missing";
    public static final String DEADLINE_DIV_ERROR = "Deadline div";
    public static final String EVENT_DIV_ERROR = "Event div";
    public static final String CMD_DEADLINE = "deadline";
    public static final String CMD_EVENT = "event";
    public static final String CMD_DONE = "done";
    public static final String CMD_DELETE = "delete";
    private static String desc;
    private static String time;
    private static String indexStr;
    private static int index;
    private static String[] cmdSplit;
    private static int cmdLength;
    private static String div;
    private static String divError;

    public static Task deadlineeventTask(String userCmd, String type) throws DukeException{
        setParam(type);
        if(!userCmd.contains(div)){
            throw new DukeException(divError);
        }
        cmdSplit= userCmd.split(div);
        if(cmdSplit.length==2){
            desc= Parser.cmdSplit[0].trim();
            time= Parser.cmdSplit[1].trim();
        } else{
            desc= Parser.cmdSplit[0].trim();
            time=" ";
        }
        if(desc.length()< cmdLength +1){
            throw new  DukeException(DESC_MISSING);
        }
        desc=desc.substring(cmdLength +1).trim();
        if(desc.isBlank()){
            throw new DukeException (DESC_MISSING);
        }
        if(time.isBlank()){
            throw new DukeException(TIME_MISSING);
        }

        return (type.equals(CMD_DEADLINE))? new Deadline(desc,time): new Event(desc,time);

    }

    public static Task todo(String userCmd) throws DukeException {
        if(userCmd.length()<TODO_CMD_LENGTH+1){
            throw new  DukeException(DESC_MISSING);
        }
        String desc= userCmd.substring(TODO_CMD_LENGTH+1).trim();
        if(desc.isBlank()){
            throw new  DukeException(DESC_MISSING);
        }
        return new Todo(desc);
    }

    public static int donedeleteIndex(String userCmd, String type, int size) throws DukeException{
        setParam(type);
        if(userCmd.length()<cmdLength+1){
            throw new  DukeException("Index missing");
        }
        indexStr= userCmd.substring(cmdLength+1).trim();
        if(indexStr.isBlank()){
            throw new  DukeException("Index missing");
        }
        try {
            index = Integer.parseInt(indexStr) - 1;
        } catch (NumberFormatException e){
            throw new DukeException("Index not int");
        }
        if(index>size-1 || index<0){
            throw new DukeException("Index out of bounds");
        }
        return index;
    }



    private static void setParam(String type){
        switch(type){
        case CMD_DEADLINE:
            cmdLength= DEADLINE_CMD_LENGTH;
            div=DEADLINE_DIV;
            divError=DEADLINE_DIV_ERROR;
            break;
        case CMD_EVENT:
            cmdLength= EVENT_CMD_LENGTH;
            div=EVENT_DIV;
            divError=EVENT_DIV_ERROR;
            break;
        case CMD_DONE:
            cmdLength= DONE_CMD_LENGTH;
            break;
        case CMD_DELETE:
            cmdLength= DELETE_CMD_LENGTH;
            break;
        }
    }
}