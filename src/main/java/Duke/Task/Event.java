package Duke.Task;


import Duke.Parser.Parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected String time;
    protected LocalDateTime dateTime;

    public Event(String description, String time){
        super(description);
        this.time = time;
        dateTime= Parser.getLocalDateTime(time);
    }

    public String getTime() {
        return time;
    }

    public String stringDateTime(){
        return this.dateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"));
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " (at: " + stringDateTime()+")";
    }
}
