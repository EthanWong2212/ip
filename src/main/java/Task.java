import java.util.Arrays;
public class Task {
    protected String description;
    protected boolean isDone;
    protected int tasknumber;

    public Task(String description, int tasknumber){
        this.description=description;
        this.isDone=false;
        this.tasknumber=tasknumber;
    }

    public String getStatusIcon() {
        return (isDone ? "[\u2713]" : "[\u2718]"); //return tick or X symbols
    }


}
