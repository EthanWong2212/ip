package Duke.Task;

import Duke.Duke;

public abstract class Task {
    protected String description;
    protected boolean done;

    public Task(String description){
        this.description=description;
        this.done=false;
    }

    public void isDone(boolean done){
        this.done=true;
        System.out.println("Great Job! The task has been marked as done:");
        System.out.println(this.getStatusIcon()+" "+this.description);
    }

    public String getStatusIcon() {
        return (done ? "[\u2713]" : "[\u2718]"); //return tick or X symbols
    }

    @Override
    public String toString(){
        return this.getStatusIcon() + " " + this.description;
    }


}
