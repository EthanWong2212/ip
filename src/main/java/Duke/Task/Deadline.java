package Duke.Task;

import Duke.DukeException;

public class Deadline extends Task{
    protected String time;

    public Deadline(String description, String time) throws DukeException {
        super(description);
        this.time = time;
        if(description.isBlank()|| time.isBlank()){
            throw new DukeException("DL incomplete");
        }
    }

    public String getTime(){
        return time;
    }

    @Override
    public String toString(){
        return "[D] "+ super.toString()+ " (by: "+ time +")" ;
    }
}
