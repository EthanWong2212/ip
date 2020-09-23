package Duke.Task;
import Duke.Ui.Ui;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> taskList;
    private static int taskDone;
    public TaskList(){
        taskList =new ArrayList<>();
        taskDone =0;
    }
    public void addTask(Task task){
        taskList.add(task);
    }
    public void deleteTask(int index){
        Task task= taskList.get(index);
        if(task.checkDone()){
            taskDone--;
        }
        taskList.remove(task);
        Ui.printTaskDeleted(task,taskList.size());
    }
    public void doneTask(int index){
        Task task= taskList.get(index);
        if(!task.checkDone()){
            task.isDone(true);
            taskDone++;
        }
        Ui.printTaskDone(task, taskList.size()-taskDone);

    }
    public void printList(){
        for(Task task: taskList) {
            System.out.println((taskList.indexOf(task)+1) + "." + task);
        }
    }
    public void setDoneCount(int taskDone){
        this.taskDone=taskDone;
    }
    public ArrayList<Task> getList(){
        return taskList;
    }
    public int getSize(){
        return taskList.size();
    }

}
