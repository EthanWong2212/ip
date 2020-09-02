public class Deadline extends Task{
    protected String timing;
    public Deadline(String description, String timing){
        super(description);
        this.timing=timing;
    }

    @Override
    public String toString(){
        return "[D] "+ super.toString()+ " (by: "+ timing.substring(3) +")" ;
    }
}
