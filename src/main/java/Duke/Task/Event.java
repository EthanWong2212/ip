package Duke.Task;

public class Event extends Task {
    protected String timing;
    public Event(String description, String timing){
        super(description);
        this.timing=timing;
    }

    public String getDesc(){
        return this.description;
    }
    public String getTime(){
        return this.timing.substring(3);
    }
    @Override
    public String toString(){
        return "[E] "+ super.toString()+ " (at: "+ timing.substring(3) +")" ;
    }
}
