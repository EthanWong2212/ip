package Duke;

public class DukeException extends Exception{
    protected String error;
    public DukeException(String error){
        this.error=error;
    }

    public void getError() {
        switch (this.error) {
        case "invalid":
            System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            break;
        case "todo incomplete":
            System.out.println("OOPS!!! The description of a todo cannot be empty. :-(");
            break;
        case "DL divider missing":
            System.out.println("OOPS!!! The divider (\"/\") for deadline is missing. :-(");
            break;
        case "DL incomplete":
            System.out.println("OOPS!!! The description and timing of a deadline cannot be empty. :-(");
            break;
        case "Done out of bounds":
            System.out.println("OOPS!!! The item you have marked as done does not seem to exist :-(");
            break;
        case "Done empty"  :
            System.out.println("OOPS!!! I do not know what to mark as done :-(");
            break;
        }
    }
}
