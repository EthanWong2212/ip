package Duke.Task;

import Duke.DukeException;

public class Todo extends Task{
<<<<<<< HEAD
=======

>>>>>>> branch-Level-5
    public Todo(String description) throws DukeException {
        super(description);
        //In case description is " "
        if(description.isBlank()){
            throw new DukeException("todo incomplete");
        }
    }

    @Override
    public String toString(){
        return "[T] "+super.toString();
    }
}
