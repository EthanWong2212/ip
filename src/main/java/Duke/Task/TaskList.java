package Duke.Task;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> task_list;
    private static int size;
    private static int task_done;
    public TaskList(){
        task_list=new ArrayList<>();
        size=0;
        task_done=0;
    }
    public void addTask(Task task){
        task_list.add(task);
        size++;
        System.out.println("Got it. I've added this task:");
        System.out.println("  "+ task);
        System.out.println("Now you have "+ size+ (size==1?" task":" tasks")+" in the list");
    }
    public void deleteTask(int index){
        size--;
        Task t=task_list.get(index);
        task_list.remove(t);
        System.out.println("Noted. I've removed this task:");
        System.out.println("  "+ t);
        System.out.println("Now you have "+ size+ (size==1?" task":" tasks")+" in the list");
    }
    public void doneTask(int index){
        Task t=task_list.get(index);
        if(t.checkDone()){
            System.out.println("The task has already been mark as done");
        }else {
            t.isDone(true);
            task_done++;
            System.out.println("Great Job! The task has been marked as done:");
            System.out.println(t);
            System.out.println("You have " + (size - task_done) + " tasks not done");
        }

    }
    public void printList(){
        for(Task task:task_list) {
            System.out.println((task_list.indexOf(task)+1) + "." + task);
        }
    }

}
