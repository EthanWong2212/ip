import java.util.Arrays;
public class Task {
    protected String description;
    protected static String [] list=new String[100];
    protected static int list_index=0;

    public Task(String description){
        this.description=description;
        runDescription(description);
    }

    public void runDescription(String description){
        int print_index=1;
        if(description.equals("list")){
            for(String item :Arrays.copyOf(list,list_index)){
                System.out.println(print_index+". "+item);
                print_index++;
            }
        } else {
            list[list_index] = description;
            list_index++;
            System.out.println("added: " + description);
        }

    }


}
