package Duke.Parser;

import Duke.DukeException;
import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Parser {
    private static final String DEADLINE_DIV="/by";
    private static final String EVENT_DIV="/at";
    public static final int DEADLINE_CMD_LENGTH = 8;
    public static final int EVENT_CMD_LENGTH=5;
    public static final int TODO_CMD_LENGTH=4;
    public static final int DONE_CMD_LENGTH=4;
    public static final int DELETE_CMD_LENGTH=6;
    public static final int FIND_CMD_LENGTH=4;
    public static final String DESC_MISSING = "Desc missing";
    public static final String TIME_MISSING = "Time missing";
    public static final String DEADLINE_DIV_ERROR = "Deadline div";
    public static final String EVENT_DIV_ERROR = "Event div";
    public static final String CMD_DEADLINE = "deadline";
    public static final String CMD_EVENT = "event";
    public static final String CMD_DONE = "done";
    public static final String CMD_DELETE = "delete";
    private static int cmdLength;
    private static String div;
    private static String divError;

    /**
     * Processes the user command and returns required task for deadline and event commands.
     * Checks for errors and validity of user input.
     *
     * @param userCmd Full input by user.
     * @param type Command type to establish if userCmd is processed as deadline or event command.
     * @return required task.
     * @throws DukeException If errors under DukeExceptions are caught.
     */

    public static Task getDeadlineEventTask(String userCmd, String type) throws DukeException{
        setParam(type);
        String desc;
        String time;
        String[] cmdSplit;
        if(!userCmd.contains(div)){
            throw new DukeException(divError);
        }
        cmdSplit= userCmd.split(div);
        if(cmdSplit.length==2){
            desc= cmdSplit[0].trim();
            time= cmdSplit[1].trim();
        } else{
            desc= cmdSplit[0].trim();
            time=" ";
        }
        if(desc.length()< cmdLength +1){
            throw new DukeException(DESC_MISSING);
        }
        if(desc.isBlank()){
            throw new DukeException (DESC_MISSING);
        }
        if(time.isBlank()){
            throw new DukeException(TIME_MISSING);
        }
        desc=desc.substring(cmdLength +1).trim();
        dateTimeValid(time);
        return (type.equals(CMD_DEADLINE))? new Deadline(desc,time): new Event(desc,time);

    }


    /**
     * Processes the user command and returns todo object for todo commands.
     * Checks for errors and validity of user input.
     *
     * @param userCmd Full input by user.
     * @return Todo Task object.
     * @throws DukeException If errors under DukeExceptions are caught.
     */


    public static Task getTodoTask(String userCmd) throws DukeException {
        if(userCmd.length()<TODO_CMD_LENGTH+1){
            throw new  DukeException(DESC_MISSING);
        }
        String desc= userCmd.substring(TODO_CMD_LENGTH+1).trim();
        if(desc.isBlank()){
            throw new  DukeException(DESC_MISSING);
        }
        return new Todo(desc);
    }


    /**
     * Processes the user command and returns required index for delete and done commands.
     * Checks for errors and validity of user input.
     *
     * @param userCmd Full input by user.
     * @param type Command type to establish if userCmd is processed as done or delete command.
     * @param size Size of taskList
     * @return index integer.
     * @throws DukeException If errors under DukeExceptions are caught.
     */

    public static int getDoneDeleteIndex(String userCmd, String type, int size) throws DukeException{
        setParam(type);
        String indexStr;
        int index;
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

    /**
     * Processes the user command and returns keyword for find commands.
     * Checks for errors and validity of user input.
     *
     * @param userCmd Full input by user.
     * @return keyword for find command
     * @throws DukeException If errors under DukeExceptions are caught.
     */

    public static String getFindKeyword(String userCmd) throws DukeException {
        String key;
        if(userCmd.length()<FIND_CMD_LENGTH+1){
            throw new DukeException("Find blank");
        }
        key=userCmd.substring(FIND_CMD_LENGTH+1).trim();
        if (key.isBlank()){
            throw new DukeException("Find blank");
        }
        return key;

    }


    /**
     * Sets parameter values according to the command type.
     * This will thus affect how userCmd are processed in donedeleteIndex and deadlineeventTask
     *
     * @param type Command type
     */
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

    /**
     * Checks raw dateTime from user input for errors
     *
     * @param dateTime raw dateTime input
     * @throws DukeException If errors under DukeExceptions are caught.
     */

    private static void dateTimeValid(String dateTime) throws DukeException {
        try {
            LocalDateTime dt = getLocalDateTime(dateTime);
        } catch (DateTimeParseException | ArrayIndexOutOfBoundsException e) {
            throw new DukeException("DateTime invalid");
        }
        LocalDateTime dt = getLocalDateTime(dateTime);
        LocalDateTime dt_now=LocalDateTime.now();
        if(dt.isBefore(dt_now)){
            throw new DukeException("DateTime before");
        }
    }

    /**
     * Parses raw dateTime from user input and returns LocalDateTime
     *
     * @param dateTime raw dateTime input to be parsed
     * @return LocalDateTime
     */
    public static LocalDateTime getLocalDateTime(String dateTime){
        String [] splitTime= dateTime.split(" ");
        String [] date= splitTime[0].split("/");
        String [] time= splitTime[1].split(":");
        String year= getDateTimeNumber(date[2].trim());
        String month= getDateTimeNumber(date[1].trim());
        String day= getDateTimeNumber(date[0].trim());
        String hr= getDateTimeNumber(time[0].trim());
        String min= getDateTimeNumber(time[1].trim());
        LocalDateTime dt= LocalDateTime.parse(year+"-"+month+"-"+day+"T"+hr+":"+min);
        return dt;
    }

    /**
     * Modifies number in order for it to be read as in LocalDateTime.parse
     *
     * @param number
     * @return number readable by LocalDateTime
     */
    private static String getDateTimeNumber(String number){
        if(number.length()==1){
            return ("0"+number);
        } else{
            return number;
        }
    }
}