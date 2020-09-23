package Duke.Task;

import Duke.DukeException;

public class Todo extends Task{
    public Todo(String description) throws DukeException {
        super(description);
        //In case description is " "
        if(description.isBlank()){
            throw new DukeException("Desc missing");
        }
    }

    @Override
    public String toString(){
        return "[T] "+super.toString();
    }
}
