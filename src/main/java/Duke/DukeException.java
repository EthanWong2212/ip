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
        case "Index missing":
            System.out.println("Index for command not provided");
            break;
        case "Index out of bounds":
            System.out.println("Index out of bounds");
            break;
        case "Index not int":
            System.out.println("Index needs to be an integer");
            break;
        case "Deadline div":
            System.out.println("OOPS!!! The divider (\"/by\") for deadline is missing. :-(");
            break;
        case "Event div":
            System.out.println("OOPS!!! The divider (\"/at\") for deadline is missing. :-(");
            break;
        case "Time missing":
            System.out.println("OOPS!!! The task timing is missing. :-(");
            break;
        case "Desc missing":
            System.out.println("OOPS!!! The task description is missing. :-(");
            break;
        case "Find blank":
            System.out.println("OOPS!!! I'm sorry but I don't know what you are looking for");
            break;
        case "DateTime invalid":
            System.out.println("Please input date and time in this format:");
            System.out.println("DD/MM/YYYY HH:mm");
            break;
        case "DateTime before":
            System.out.println("The date and time you have input has passed :-(");
            System.out.println("Please input valid date");
            break;

        }
    }
}
