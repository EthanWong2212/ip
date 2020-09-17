package Duke.Task;

import Duke.DukeException;

public class Deadline extends Task{
    protected String timing;

    public Deadline(String description, String timing) throws DukeException {
        super(description);
        this.timing=timing;
        if(description.isBlank()||timing.isBlank()){
            throw new DukeException("DL incomplete");
        }
    }

    public String getTime(){
        return this.timing.substring(3);
    }

    @Override
    public String toString(){
        return "[D] "+ super.toString()+ " (by: "+ timing.substring(3) +")" ;
    }
}
