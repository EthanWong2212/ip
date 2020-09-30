package Duke.Task;
import Duke.Ui.Ui;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> taskList;
    private static int doneCount;

    public TaskList(){
        taskList =new ArrayList<>();
        doneCount =0;
    }

    /**
     * Adds task to taskList
     *
     * @param task task to be added to taskList
     */
    public void addTask(Task task){
        taskList.add(task);
    }

    /**
     * Deletes task from specific index in taskList
     *
     * @param index index of task to delete
     */
    public void deleteTask(int index){
        Task task= taskList.get(index);
        if(task.checkDone()){
            doneCount--;
        }
        taskList.remove(task);
        Ui.printTaskDeleted(task,taskList.size());
    }

    /**
     * Marks task from specific index in taskList as done
     *
     * @param index index of task to mark as done
     */

    public void doneTask(int index){
        Task task= taskList.get(index);
        if(!task.checkDone()){
            task.isDone(true);
            doneCount++;
        }
        Ui.printTaskDone(task, taskList.size()- doneCount);

    }

    public void printList(){
        for(Task task: taskList) {
            System.out.println((taskList.indexOf(task)+1) + "." + task);
        }
    }

    /**
     * Changes the count of doneCount in taskList
     *
     * @param doneCount number of tasks done
     */
    public void setDoneCount(int doneCount) {
        this.doneCount = doneCount;
    }

    public void findTask(String key){
        boolean found=false;
        for (Task task:taskList){
            if(task.getDesc().toLowerCase().contains(key.toLowerCase())){
                System.out.println((taskList.indexOf(task)+1) + "." +task);
                found=true;
            }
        }
        if(found==false){
            System.out.println("There aren't any matching tasks in your list :-(");
        }
    }

    /** Gets taskList */
    public ArrayList<Task> getList(){
        return taskList;
    }
    /** Gets size of taskList*/
    public int getSize(){
        return taskList.size();
    }

}
