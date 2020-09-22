package Duke.Task;
import Duke.Ui.Ui;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> taskList;
    private static int size;
    private static int taskDone;
    public TaskList(){
        taskList =new ArrayList<>();
        size=0;
        taskDone =0;
    }
    public void addTask(Task task){
        taskList.add(task);
        size++;
    }
    public void deleteTask(int index){
        size--;
        Task task= taskList.get(index);
        if(task.checkDone()){
            taskDone--;
        }
        taskList.remove(task);
        Ui.printTaskDeleted(task,size);
    }
    public void doneTask(int index){
        Task task= taskList.get(index);
        if(!task.checkDone()){
            task.isDone(true);
            taskDone++;
        }
        Ui.printTaskDone(task, size-taskDone);

    }
    public void printList(){
        for(Task task: taskList) {
            System.out.println((taskList.indexOf(task)+1) + "." + task);
        }
    }
    public void setDoneCount(int taskDone){
        this.taskDone=taskDone;
    }
    public void setSize(int size){
        this.size=size;
    }
    public ArrayList<Task> getList(){
        return taskList;
    }
    public int getSize(){
        return size;
    }

}
